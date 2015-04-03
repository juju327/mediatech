import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Mediatek {

	// fichier de sérialisation
	private static final String file_db = "data.db";
	private ArrayList<Emprunt> emprunts;
	private HashMap<String, Document> documents;
	private HashMap<String, Abonne> abonnes;
	private ArrayList<Auteur> auteurs;

	private static Mediatek instance;

	private static ConcreteFactory factory;
	private Parametres parametres;

	private Controleur_emprunt controleur_emprunt;
	private Controleur_document controleur_document;

	private Mediatek() {
		setControleur_documents(new Controleur_document(this));
		setParametres(new Parametres(5, 5, 3, 15, 15));
		newDB();
		init();
		saveDB();
		afficher();
	}

	public static Mediatek getInstance() {
		if (instance == null) {
			instance = new Mediatek();
		}
		return instance;

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

	public Controleur_document getControleur_documents() {
		return controleur_document;
	}

	private void setControleur_documents(Controleur_document controleur_document) {
		this.controleur_document = controleur_document;
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

	public ArrayList<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(ArrayList<Auteur> auteurs) {
		this.auteurs = auteurs;
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
			String numeroISBN, GenreLivre genre, Auteur auteurs) {
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
			GenreMusique genre, Auteur auteur) {
		Musique musique = getFactory().creerMusique(titre, dateParution, genre,
				auteur);
		documents.put(musique.getReference(), musique);
	}

	/**
	 * Ajoute un abonné à la collection d'abonné de la mediatek
	 * 
	 * @param nom
	 *            String
	 * @param prenom
	 *            String
	 * @param adresse
	 *            String String
	 * @param dateNaissance
	 *            Date
	 * @param numeroAbo
	 *            String
	 */
	public String ajouterAbonne(String nom, String prenom, String adresse,
			String dateNaissance) {
		Abonne abo = getFactory().creerAbonne(nom, prenom, adresse,
				dateNaissance);
		getAbonnes().put(abo.getNumero(), abo);
		saveDB();
		return abo.getNumero();
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
	 * Sauvegarde du fichier de sérialisation
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

				abonnes = (HashMap<String, Abonne>) ois.readObject();
				documents = (HashMap<String, Document>) ois.readObject();
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
		System.out.println("Liste d'abonnés");
		for (Abonne a : abonnes.values()) {
			System.out.println(a.getNom() + " " + a.getPrenom() + " n°"
					+ a.getNumero());
		}

		System.out.println("\nListe de documents");
		for (Document d : documents.values()) {
			System.out.println(d.getTitre() + " - " + d.getAuteur().getNom()
					+ " - " + d.getDateParution() + " - " + d.getGenre()
					+ " - n°" + d.getReference());
		}

		System.out.println("\nListe d'emprunts");
		for (int i = 0; i < emprunts.size(); i++) {
			System.out.println(emprunts.get(i).getEmprunteur().getNom()
					+ " "
					+ emprunts.get(i).getEmprunteur().getPrenom()
					+ " a emprunté "
					+ emprunts.get(i).getPret().getTitre()
					+ " de "
					+ emprunts.get(i).getPret().getAuteur().getNom()
					+ " le "
					+ controleur_document.dateToString(emprunts.get(i)
							.getDateEmprunt())
					+ " - à rendre le "
					+ controleur_document.dateToString(emprunts.get(i)
							.getDateRetour()));
		}
	}

	public void addEmprunt(Emprunt emprunt) {
		this.emprunts.add(emprunt);

	}

	public void remove(Emprunt emprunt) {
		this.emprunts.remove(emprunt);

	}

	public void supprimerAbonne(String nbAbo) {
		abonnes.remove(nbAbo);
	}

	// Création d'un jeu de test
	private void init() {

		controleur_emprunt = new Controleur_emprunt(this);

		Auteur a1 = new Auteur("Rowling");
		Auteur a2 = new Auteur("Franquin");
		Auteur a3 = new Auteur("Tolkien");
		Auteur a4 = new Auteur("Lerouge");
		Auteur a5 = new Auteur("Levert");
		Auteur a6 = new Auteur("Lebleu");
		Auteur a7 = new Auteur("Lenoir");
		Auteur a8 = new Auteur("Leblanc");

		ArrayList<Auteur> aut_tmp = new ArrayList<>();
		aut_tmp.add(a1);
		aut_tmp.add(a2);
		aut_tmp.add(a3);
		aut_tmp.add(a4);
		aut_tmp.add(a5);
		aut_tmp.add(a6);
		aut_tmp.add(a7);
		aut_tmp.add(a8);

		setAuteurs(aut_tmp);

		Livre l1 = new Livre("Harry Potter à l'Ecole des Sorciers",
				"01/01/1995", "1", GenreLivre.Roman, a1);
		Livre l2 = new Livre("Harry Potter et la Chambre des Secrets",
				"01/01/1995", "2", GenreLivre.Roman, a1);
		Livre l3 = new Livre("Harry Potter et le Prisonnier d'Azkaban",
				"01/01/1995", "3", GenreLivre.Roman, a1);
		Livre l4 = new Livre("Harry Potter et la Coupe de Feu", "01/01/1995",
				"4", GenreLivre.Roman, a1);
		Livre l5 = new Livre("Harry Potter et l'Ordre du Phoenix",
				"01/01/1995", "5", GenreLivre.Roman, a1);
		Livre l6 = new Livre("Harry Potter et le Prince de Sang-Mêlé",
				"01/01/1995", "6", GenreLivre.Roman, a1);
		Livre l7 = new Livre("Harry Potter et les Reliques de la Mort",
				"01/01/1995", "7", GenreLivre.Roman, a1);
		Livre l8 = new Livre("Le seigneur des anneaux 1", "01/01/1995", "8",
				GenreLivre.Roman, a3);
		Livre l9 = new Livre("Le seigneur des anneaux 2", "01/01/1995", "9",
				GenreLivre.Roman, a3);
		Livre l10 = new Livre("Le seigneur des anneaux 3", "01/01/1995", "10",
				GenreLivre.Roman, a3);
		Livre l11 = new Livre("Le petit Spirou", "01/01/1995", "11",
				GenreLivre.BD, a2);
		Livre l12 = new Livre("Le petit Spirou : Le retour", "01/01/1995",
				"12", GenreLivre.BD, a2);
		Livre l13 = new Livre("Naruto", "01/01/1995", "13", GenreLivre.Manga,
				a4);
		Livre l14 = new Livre("One Piece", "01/01/1995", "14",
				GenreLivre.Manga, a5);
		Livre l15 = new Livre("La vie des lions", "01/01/1995", "15",
				GenreLivre.Documentaire, a6);
		Livre l16 = new Livre("Dauphins : le grand Mystère", "01/01/1995",
				"16", GenreLivre.Documentaire, a7);
		Livre l17 = new Livre("Les formes", "01/01/1995", "17",
				GenreLivre.Jeunesse, a8);
		Livre l18 = new Livre("Les couleurs", "01/01/1995", "18",
				GenreLivre.Jeunesse, a8);

		documents.put(l1.getReference(), l1);
		documents.put(l2.getReference(), l2);
		documents.put(l3.getReference(), l3);
		documents.put(l4.getReference(), l4);
		documents.put(l5.getReference(), l5);
		documents.put(l6.getReference(), l6);
		documents.put(l7.getReference(), l7);
		documents.put(l8.getReference(), l8);
		documents.put(l9.getReference(), l9);
		documents.put(l10.getReference(), l10);
		documents.put(l11.getReference(), l11);
		documents.put(l12.getReference(), l12);
		documents.put(l13.getReference(), l13);
		documents.put(l14.getReference(), l14);
		documents.put(l15.getReference(), l15);
		documents.put(l16.getReference(), l16);
		documents.put(l17.getReference(), l17);
		documents.put(l18.getReference(), l18);

		Abonne ab1 = new Abonne("Nicolas", "Violette", "chez Nicolas",
				"01/01/1995");
		Abonne ab2 = new Abonne("Céline", "Hernandez", "chez Céline",
				"01/01/1995");
		Abonne ab3 = new Abonne("Juliette", "Pelletier", "chez Nicolas",
				"01/01/1995");
		Abonne ab4 = new Abonne("Rémi", "Pontonnier", "chez Nicolas",
				"01/01/1995");
		Abonne ab5 = new Abonne("François", "Hollande", "chez François",
				"01/01/1995");
		Abonne ab6 = new Abonne("Jules", "César", "chez l'Empereur",
				"01/01/1995");

		abonnes.put(ab1.getNumero(), ab1);
		abonnes.put(ab2.getNumero(), ab2);
		abonnes.put(ab3.getNumero(), ab3);
		abonnes.put(ab4.getNumero(), ab4);
		abonnes.put(ab5.getNumero(), ab5);
		abonnes.put(ab6.getNumero(), ab6);

		controleur_emprunt.faireEmprunt(l1, ab1);
		controleur_emprunt.faireEmprunt(l2, ab1);
		controleur_emprunt.faireEmprunt(l3, ab1);
		controleur_emprunt.faireEmprunt(l4, ab1);

		controleur_emprunt.faireEmprunt(l15, ab2);
		controleur_emprunt.faireEmprunt(l16, ab2);
		controleur_emprunt.faireEmprunt(l17, ab2);

		controleur_emprunt.faireEmprunt(l13, ab3);
		controleur_emprunt.faireEmprunt(l14, ab4);
		controleur_emprunt.faireEmprunt(l11, ab5);

	}
}
