
import java.io.Serializable;
import java.util.Date;


public class Emprunt implements Serializable{
	
	private Document pret;
	private Abonne emprunteur;	
	private Date dateEmprunt;
	private Date dateRetour;

	public Emprunt(Document pret, Abonne emprunteur, Date dateEmprunt, Date dateRetour){
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
	public Abonne getEmprunteur() {
		return emprunteur;
	}
	private void setEmprunteur(Abonne emprunteur) {
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
