import java.util.ArrayList;


public class Auteur {
	private String nom ;
	private String prenom ;
	private String nationalité ;
	private ArrayList<Document> aPublie ;
	
	public Auteur(String nom, String prenom, String nationalité) {
		setNom(nom);
		setPrenom(prenom);
		setNationalité(nationalité);
		aPublie = new ArrayList<Document>();
	}

	public String getNom() {
		return nom;
	}
	
	private void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	private void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNationalité() {
		return nationalité;
	}
	
	private void setNationalité(String nationalité) {
		this.nationalité = nationalité;
	}

	//Pour l'ArrayList
	public ArrayList<Document> getaPublie() {
		return aPublie;
	}

	/**
	 * Ajoute un document publié à la liste de l'auteur. 
	 * A utiliser, notamment, lors de l'ajout d'un auteur dans la liste des auteurs du document
	 * @param document : Document (que l'auteur a publié)
	 */
	public void addDocumentPublie(Document document){
		getaPublie().add(document);
	}

	/**
	 * Supprime un document publié à la liste de l'auteur.
	 *A utiliser, notamment, lors de la suppression d'un auteur dans la liste des auteurs du document
	 * @param document : Document (que l'auteur a publié)
	 */
	public void removeDocumentPublie(Document document){
		getaPublie().remove(document);
	}
	
	
	
	
}
