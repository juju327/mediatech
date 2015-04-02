import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Auteur  implements Serializable{
	private String nom ;
	private String prenom ;
	private String nationalité ;
	private ArrayList<Document> apublie ;
	
	public Auteur(String nom) {
		setNom(nom);
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
	
	public ArrayList<Document> getAPublie(){
		return apublie;
	}

	/**
	 * Ajoute le document à la liste des documents publiés par l'auteur
	 * Il demande aussi l'ajout de l'auteur à la liste d'auteur du document en question
	 * @param document à associé à l'auteur
	 */
	public void addAPublie(Document document){
		if(!getAPublie().contains(document)){
			getAPublie().add(document);
			document.addAuteur(this);
		}
		//212121
	}
	
	
	
}
