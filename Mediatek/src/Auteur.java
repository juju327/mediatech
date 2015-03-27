public class Auteur {
	private String nom ;
	private String prenom ;
	private String nationalité ;
	
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


	
	
	
}
