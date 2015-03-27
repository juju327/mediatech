import java.util.ArrayList;
import java.util.Date;


public class Abonné {
	
	private String nom;
	private String prenom;
	private String adresse;
	private Date dateNaissance;
	private String numero;
	private ArrayList<Emprunt> emprunts;
	
	// Constructor
	public Abonné(String nom, String prenom, String adresse, Date date, String num){
		setNom(nom);
		setPrenom(prenom);
		setAdresse(adresse);
		setDateNaissance(date);
		setNumero(num);
		emprunts = new ArrayList<Emprunt>();
	}
	
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
	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}
	private void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	// méthodes
	/**
	 * ajoute le document doc à la liste des emprunts de cet abonné
	 * @param doc le document à emprunter
	 */
	public void emprunter(Emprunt emprunt){
		emprunts.add(emprunt);
	}
	
	/**
	 * enlève le document doc de la liste des emprunts de cet abonné
	 * @param doc le document à rendre
	 */
	public void rendre(Emprunt emprunt){
		emprunts.remove(emprunt);
	}
	
	// it's a com!

}
