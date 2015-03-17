
public abstract class Document {
	private String titre ;
	private String dateParution ;
	private String reference ;
	private int dureeMax ;
	private int nbMax ;
	private Emprunt empruntDoc;

	public Document(String titre, String dateParution, String reference,
			int dureeMax, int nbMax) {
		setTitre(titre);
		setDateParution(dateParution);
		setReference(reference);
		setDureeMax(dureeMax);
		setNbMax(nbMax);
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
	
	
	
}
