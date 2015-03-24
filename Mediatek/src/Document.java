import java.util.ArrayList;


public abstract class Document {
	private String titre ;
	private String dateParution ;
	private String reference ;
	private boolean disponible;
	private ArrayList<Auteur> auteurs;

	public Document(String titre, String dateParution, ArrayList<Auteur> auteurs) {
		setTitre(titre);
		setDateParution(dateParution);
		createReference(titre, dateParution);
		setDisponible(true);
		setAuteurs(auteurs);
	}


	public ArrayList<Auteur> getAuteurs() {
		return auteurs;
	}
	
	private void setAuteurs(ArrayList<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getTitre() {
		return titre;
	}	
	private void setTitre(String titre) {
		this.titre = titre;
	}	
	public String getDateParution() {
		return dateParution;
	}	
	private void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}	
	public String getReference() {
		return reference;
	}	
	private void setReference(String reference) {
		this.reference = reference;
	}	
	public void newReference(String reference){
		setReference(reference);
	}	
	
	/**
	 * Ajoute un auteur au document 
	 * @param auteur : Auteur (qui a publié le livre)
	 */
	public void addAuteur(Auteur auteur){
		getAuteurs().add(auteur);
	}
	
	/**
	 * Supprimer un auteur du document
	 * @param auteur : Auteur (qui a publié le livre)
	 */
	public void removeAuteur(Auteur auteur){
		getAuteurs().remove(auteur);
	}
	
	public abstract void createReference(String titre, String dateParution);
	
	
}
