import java.util.Date;


public class Abonné {
	
	private String nom;
	private String prenom;
	private String adresse;
	private Date dateNaissance;
	private String numero;
	//private ArrayList<Document> emprunts;
	
	// getters & setters
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public String getNumero() {
		return numero;
	}
	private void setNom(String nom) {
		this.nom = nom;
	}
	private void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	private void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	private void setNumero(String numero) {
		this.numero = numero;
	}
	
	// méthodes
	/**
	 * réalise un prêt pour un abonné
	 * @param ref la référence du document
	 */
	public void emprunter(String ref){
		
	}
}
