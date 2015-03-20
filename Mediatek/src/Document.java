import java.util.ArrayList;


public abstract class Document {
	private String titre ;
	private String dateParution ;
	private String reference ;
	private int dureeMax ;
	private int nbMax ;
	
	private ArrayList<Auteur> estPubliePar;

	public Document(String titre, String dateParution, String reference,
			int dureeMax, int nbMax) {
		setTitre(titre);
		setDateParution(dateParution);
		setReference(reference);
		setDureeMax(dureeMax);
		setNbMax(nbMax);
		estPubliePar = new ArrayList<Auteur>();
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
	
	public int getDureeMax() {
		return dureeMax;
	}
	
	private void setDureeMax(int dureeMax) {
		this.dureeMax = dureeMax;
	}
	
	public int getNbMax() {
		return nbMax;
	}
	
	private void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}

	//Pour la liste des auteurs estPubliePar 
	public ArrayList<Auteur> getEstPubliePar() {
		return estPubliePar;
	}
	
	/**
	 * Ajoute un auteur au document 
	 * @param auteur : Auteur (qui a publié le livre)
	 */
	public void addAuteur(Auteur auteur){
		getEstPubliePar().add(auteur);
	}
	
	/**
	 * Supprimer un auteur du document
	 * @param auteur : Auteur (qui a publié le livre)
	 */
	public void removeAuteur(Auteur auteur){
		getEstPubliePar().remove(auteur);
	}
	
	
	
}
