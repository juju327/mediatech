import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Mediatek {
	
	/**
	 * liste des emprunts en cours
	 */
	private ArrayList<Emprunt> emprunts;
	private HashMap<String,Document> documents;
	private HashMap<String,Abonné> abonnes;	
	private int quotaGlobal = 6;
	private static ConcreteFactory factory;

	public Mediatek(){
		documents = new HashMap<>();
		abonnes = new HashMap<>();
	}

	public int getQuotaGlobal() {
		return quotaGlobal;
	}
	private void setQuotaGlobal(int quotaGlobal) {
		this.quotaGlobal = quotaGlobal;
	}
	public HashMap<String,Document> getDocuments() {
		return documents;
	}
	public HashMap<String,Abonné> getAbonnes() {
		return abonnes;
	}
	/**
	 * 
	 * @return la liste des emprunts en cours dans la médiathèque
	 */
	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}
	private void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	private void setAbonnes(HashMap<String,Abonné> abonnes) {
		this.abonnes = abonnes;
	}
	private void setDocuments(HashMap<String,Document> documents) {
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
	
	public ConcreteFactory getFactory(){
		if(factory == null) factory = new ConcreteFactory();
		return factory;
	}
	
	public void ajouterLivre(String titre, String dateParution, String numeroISBN ,GenreLivre genre){
		Livre livre = getFactory().creerLivre(titre, dateParution, numeroISBN, genre);
		documents.put(livre.getReference(), livre);
	}
	
	public void ajouterMusique(String titre, String dateParution, GenreMusique genre){
		Musique musique = getFactory().creerMusique(titre, dateParution, genre);
		documents.put(musique.getReference(), musique);
	}
	
	
	
	
}
