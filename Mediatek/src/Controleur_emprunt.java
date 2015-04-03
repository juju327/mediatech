import java.util.Date;
import java.util.Map.Entry;



public class Controleur_emprunt extends Controleur{
	
	public Controleur_emprunt(Mediatek mediatek) {
		super(mediatek);
	}
	
	/**
	 * Recherche parmi la liste des documents si la référence existe
	 * @param reference : reference d'un document
	 * @return true si la référence existe sinon false
	 */
	
	public boolean referenceDocumentValide(String reference){
		return getMediatek().getDocuments().containsKey(reference);
	}
	  
	
	/**
	 * Recherche si le quota pour le type du document n'est pas dépassé pour l'abonné
	 * @param numeroAbo : numéro d'un abonné
	 * @param document : document
	 * @return true si le quota pour le type du document n'est pas dépassé sinon false
	 */
	/*public boolean quotaTypeNonDepasse(String numeroAbo, Document document){
		return true ;
	} */
	
	/**
	 * Recherche si le document est disponible
	 * @param document 
	 * @return true si le document est disponible sinon false
	 */
	public boolean documentDisponible(Document document){
		if(document.isDisponible()){
			return true;
		}else{
			return false ;
		}
	}
	
	/**
	 * Recherche si le quota globale (nombre total d'emprunt) de l'abonné n'est pas dépassé grâce 
	 * à la liste d'emprunt 
	 * @param numeroAbo : numéro d'un abonné
	 * @return true si le quota global n'est pas dépassé sinon false
	 */
	public boolean quotaGlobalNonDepasse(Abonne abo){
		if(abo.getEmprunts().size()>getMediatek().getParametres().getQuotaGlobal()){
			return false ;
		}else{
			return true;
		}
	}
	
	/**
	 * emprunte un document pour un abonné
	 * 
	 * @param refDoc
	 *            la référence du document à emprunter
	 * @param numAb
	 *            le numéro de l'abonné
	 */
	public void faireEmprunt(Document doc, Abonne abonne){
		Date dateJour = new Date();
		
		Date dateRetour = addToDate(new Date(), getMediatek().getParametres().getTempsMaxLivre());
			
		Emprunt emprunt = new Emprunt(doc, abonne, dateJour, dateRetour);
		abonne.emprunter(emprunt);
		getMediatek().addEmprunt(emprunt);
		emprunt.getPret().setDisponible(false);		
	}

	/**
	 * retourne un document d'un abonné
	 * 
	 * @param refDoc
	 *            la référence du document à rendre
	 * @param numAb
	 *            le numéro de l'abonné
	 */
	public void faireRetour(Emprunt emprunt, Abonne abonne) {
		emprunt.getPret().setDisponible(true);
		abonne.rendre(emprunt);
		getMediatek().remove(emprunt);

	}
	

	
	
}
