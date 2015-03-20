import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Mediatek {

	private HashMap<Document,String> documents;
	private HashMap<Abonné,String> abonnes;
	private ArrayList<Emprunt> emprunts;
	
	private int quotaGlobal = 6;
	
	

	public int getQuotaGlobal() {
		return quotaGlobal;
	}
	private void setQuotaGlobal(int quotaGlobal) {
		this.quotaGlobal = quotaGlobal;
	}
	public HashMap<Document,String> getDocuments() {
		return documents;
	}
	public HashMap<Abonné,String> getAbonnes() {
		return abonnes;
	}
	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}
	private void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	private void setAbonnes(HashMap<Abonné,String> abonnes) {
		this.abonnes = abonnes;
	}
	private void setDocuments(HashMap<Document,String> documents) {
		this.documents = documents;
	}
		
	/**
	 * emprunte un document pour un abonné
	 * @param refDoc la référence du document à emprunter
	 * @param numAb le numéro de l'abonné
	 */
	public void faireEmprunt(Document doc, Abonné abonne){
		Date dateJour = new Date();
		int nbJours = doc.getDureeMax();
		
		Date dateRetour = addToDate(new Date(), nbJours);
			
		Emprunt emprunt = new Emprunt(doc, abonne, dateJour, dateRetour);
		abonne.emprunter(emprunt);
		emprunts.add(emprunt);
		emprunt.getPret().setDisponible(false);
	}
	
	/**
	 * retourne un document d'un abonné
	 * @param refDoc la référence du document à rendre
	 * @param numAb le numéro de l'abonné
	 */
	public void faireRetour(Emprunt emprunt, Abonné abonne){
		emprunt.getPret().setDisponible(true);
		abonne.rendre(emprunt);
		emprunts.remove(emprunt);
		
	}
	
	/**
	 * ajoute jours à la date date
	 * @param date la date à laquelle ajouter les jours
	 * @param jours le nombre de jours à ajouter
	 * @return la nouvelle date
	 */
	public Date addToDate(Date date,int jours){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, jours);  
		date = c.getTime();
		return date;
	}
	
	
	
	
	
	
	
}
