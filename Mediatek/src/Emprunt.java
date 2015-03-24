import java.util.Date;


public class Emprunt {
	
	private Document pret;
	private Abonné emprunteur;	
	private Date dateEmprunt;
	private Date dateRetour;

	public Emprunt(Document pret, Abonné emprunteur, Date dateEmprunt, Date dateRetour){
		setPret(pret);
		setDateEmprunt(dateEmprunt);
		setDateRetour(dateRetour);
		setEmprunteur(emprunteur);
	}


	//getters & setters	
	public Document getPret() {
		return pret;
	}
	private void setPret(Document pret) {
		this.pret = pret;
	}
	public Abonné getEmprunteur() {
		return emprunteur;
	}
	private void setEmprunteur(Abonné emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	private void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	private void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	
	//
	
	
}
