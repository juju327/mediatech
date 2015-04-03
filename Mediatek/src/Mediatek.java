import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Mediatek {

	/**
	 * liste des emprunts en cours
	 */
	private ArrayList<Emprunt> emprunts;
	private HashMap<String, Document> documents;
	private HashMap<String, Abonne> abonnes;
	// fichier de sérialisation
	private static final String file_db = "data.db";

	private static ConcreteFactory factory;
	private Parametres parametres;

	private Controleur_documents controleur_documents;

	public Mediatek(Parametres p) {
		setControleur_documents(new Controleur_documents(this));
		newDB();
		loadDB();
		setParametres(p);
	}

	public HashMap<String, Document> getDocuments() {
		return documents;
	}

	public HashMap<String, Abonne> getAbonnes() {
		return abonnes;
	}

	/**
	 * 
	 * @return la liste des emprunts en cours dans la médiathèque
	 */
	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}

	private void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	private void setAbonnes(HashMap<String, Abonne> abonnes) {
		this.abonnes = abonnes;
	}

	private void setDocuments(HashMap<String, Document> documents) {
		this.documents = documents;
	}

	public Parametres getParametres() {
		return parametres;
	}

	private void setParametres(Parametres parametres) {
		this.parametres = parametres;
	}

	public Controleur_documents getControleur_documents() {
		return controleur_documents;
	}

	private void setControleur_documents(
			Controleur_documents controleur_documents) {
		this.controleur_documents = controleur_documents;
	}

	/**
	 * emprunte un document pour un abonné
	 * 
	 * @param refDoc
	 *            la référence du document à emprunter
	 * @param numAb
	 *            le numéro de l'abonné
	 */
	public void faireEmprunt(Document doc, Abonne abonne) {
		Date dateJour = new Date();
		// int nbJours = doc.getDureeMax();
		int nbJours = 1;
		// TODO remettre une méthode qui va bien !!
		Date dateRetour = controleur_documents.addToDate(new Date(), nbJours);

		Emprunt emprunt = new Emprunt(doc, abonne, dateJour, dateRetour);
		abonne.emprunter(emprunt);
		emprunts.add(emprunt);
		emprunt.getPret().setDisponible(false);

	}

	/**
	 * retourne un document d'un abonné
	 * 
	 * @param refDoc
	 *            la référence du document à rendre
	 * @param numAb
	 *            le numéro de l'abonné
	 */
	public void faireRetour(Emprunt emprunt, Abonne abonne) {
		emprunt.getPret().setDisponible(true);
		abonne.rendre(emprunt);
		emprunts.remove(emprunt);

	}

	/**
	 * crée une instance unique (singleton) de ConcreteFactory pour produire des
	 * documents
	 * 
	 * @return une instance unique (singleton) de ConcreteFactory
	 */
	public ConcreteFactory getFactory() {
		if (factory == null)
			factory = new ConcreteFactory();
		return factory;
	}

	/**
	 * ajoute un livre à la collection de documents de la médiathèque
	 * 
	 * @param titre
	 * @param dateParution
	 * @param numeroISBN
	 * @param genre
	 */
	public void ajouterLivre(String titre, String dateParution,
			String numeroISBN, GenreLivre genre, ArrayList<Auteur> auteurs) {
		Livre livre = getFactory().creerLivre(titre, dateParution, numeroISBN,
				genre, auteurs);
		documents.put(livre.getReference(), livre);
	}

	/**
	 * ajoute une musique à la collection de documents de la médiathèque
	 * 
	 * @param titre
	 * @param dateParution
	 * @param genre
	 */
	public void ajouterMusique(String titre, String dateParution,
			GenreMusique genre, ArrayList<Auteur> auteurs) {
		Musique musique = getFactory().creerMusique(titre, dateParution, genre,
				auteurs);
		documents.put(musique.getReference(), musique);
	}
	
	/**
	 * Ajoute un abonné à la collection d'abonné de la mediatek
	 * @param nom String
	 * @param prenom String
	 * @param adresse String String
	 * @param dateNaissance Date
	 * @param numeroAbo String
	 */
	public void ajouterAbonne(String nom, String prenom, String adresse,
			Date dateNaissance, String numeroAbo) {
		Abonne abo = getFactory().creerAbonne(nom, prenom, adresse, dateNaissance, numeroAbo);
		getAbonnes().put(abo.getNumero(), abo);
	}
	
	

	public void supprimerDocument(Document doc) {
		documents.remove(doc.getReference());
	}

	/**
	 * Création d'une nouvelle sÃ©rialisation
	 */
	public void newDB() {

		setDocuments(new HashMap<String, Document>());
		setAbonnes(new HashMap<String, Abonne>());
		setEmprunts(new ArrayList<Emprunt>());
	}

	/**
	 * Sauvegarde du fichier de sÃ©rialisation
	 */

	public boolean saveDB() {
		File file;
		boolean success = true;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		file = new File(file_db);
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			// ici on sauvegarde nos données
			// oos.writeInt(numDerMonit);
			oos.writeObject(abonnes);
			oos.writeObject(documents);
			oos.writeObject(emprunts);

		} catch (Exception e) {
			System.out.println("SAVE" + e);
			success = false;
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}

		}
		return success;
	}

	/**
	 * Chargement des données Ã partir d'un fichier de sérialisation
	 */
	public boolean loadDB() {
		boolean success = true;
		File file = new File(file_db);

		if (file.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;

			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);

				// numDerMonit = ois.readInt();

				// on rajoute les abonnés qui existent dans le fichier à ceux
				// qui existent
				// déjà au lieu de tout supprimer à chaque ouverture du logiciel
				/*
				 * 
				 * HashMap<String,Abonne> abo_tmp = new
				 * HashMap<>((HashMap<String,Abonne>) ois.readObject());
				 * for(Abonne a : abo_tmp.values() ){ abonnes.put(a.getNumero(),
				 * a); }
				 * 
				 * HashMap<String,Document> doc_tmp = new
				 * HashMap<>((HashMap<String,Document>) ois.readObject());
				 * for(Document d : doc_tmp.values() ){
				 * documents.put(d.getReference(), d); }
				 */
				/*
				 * ArrayList<Emprunt> emp_tmp = new
				 * ArrayList<Emprunt>((ArrayList<Emprunt>) ois.readObject());
				 * for(int i=0; i<emp_tmp.size(); i++){
				 * emprunts.add(emp_tmp.get(i)); }
				 */
				abonnes = (HashMap<String, Abonne>) ois.readObject();
				documents = (HashMap<String, Document>) ois.readObject();

				// TODO exception ici ?
				emprunts = (ArrayList<Emprunt>) ois.readObject();

				afficher();

			} catch (Exception e) {
				System.out.println("LOAD" + e);
				success = false;
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
					}
				}

				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
					}
				}
			}
		} else {
			success = false;
		}
		return success;
	}

	// ///
	public void afficher() {
		System.out.println("Liste d'abonnés \n");
		for (Abonne a : abonnes.values()) {
			System.out.println("nom : " + a.getNom() + " numero"
					+ a.getNumero());
		}

		System.out.println("Liste de documents\n ");
		for (Document d : documents.values()) {
			System.out.println("titre : " + d.getTitre()
					+ " date de parution : " + d.getDateParution()
					+ " genre : " + d.getGenre());
		}
	}
}
