

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
//coucou

public class Abonne implements Serializable{

	// ouaish
	private String nom;
	private String prenom;
	private String adresse;
	private String dateNaissance;
	private String numero;
	private ArrayList<Emprunt> emprunts;
	
	// Constructor
	public Abonne(String nom, String prenom, String adresse, String date){
		setNom(nom);
		setPrenom(prenom);
		setAdresse(adresse);
		setDateNaissance(date);
		createNumeroAbo();
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
	public String getDateNaissance() {
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
	private void setDateNaissance(String dateNaissance) {
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
	
	private void createNumeroAbo(){
		Random random = new Random();
		setNumero("A"+getNom().charAt(0)+getPrenom().charAt(0)+random.nextInt(10)+random.nextInt(10));
		
	}

}
