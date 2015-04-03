

public class Controleur_emprunt extends Controleur{
	
	public Controleur_emprunt(Mediatek mediatek) {
		super(mediatek);
		// TODO Auto-generated constructor stub
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
	public boolean quotaGlobalNonDepasse(Abonné abo){
		if(abo.getEmprunts().size()>getMediatek().getParametres().getQuotaGlobal()){
			return false ;
		}else{
			return true;
		}
	}
	
	
}
