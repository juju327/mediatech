import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EmpruntControleur {
	private Mediatek laMediatek = new Mediatek() ;
	
	/**
	 * Recherche si le numéro d'abonné passé en paramètre appartient à la liste des abonnés de la médiatech.
	 * @param numeroAbo : numéro d'un abonné
	 * @return true si le numéro d'abonné existe sinon false
	 */
	public boolean numeroAbonneValide(String numeroAbo){
		ArrayList<Abonné> abonnes = new ArrayList<>();
		Iterator<Abonné> itr = abonnes.iterator();
		boolean trouve = false ;
		while (itr.hasNext() && !trouve) {
			Abonné element = itr.next();
			if(element.getNumero() == numeroAbo){
				trouve= true ;
			}
		}
		return trouve ;
	}
	
	/**
	 * Recherche si le quota globale (nombre total d'emprunt) de l'abonné n'est pas dépassé grâce 
	 * à la liste d'emprunt 
	 * @param numeroAbo : numéro d'un abonné
	 * @return true si le quota global n'est pas dépassé sinon false
	 */
	public boolean quotaGlobalNonDepasse(String numeroAbo){
		
		return true ;
	}
	
	
	/**
	 * Recherche parmi la liste des documents si la référence existe
	 * @param reference : reference d'un document
	 * @return true si la référence existe sinon false
	 */
	
	public boolean referenceDocumentValide(String reference){
		ArrayList<Document> documents = new ArrayList<>();
		Iterator<Document> itr = documents.iterator();
		boolean trouve = false ;
		while (itr.hasNext() && !trouve) {
			Document element = itr.next();
			if(element.getReference() == reference){
				trouve= true ;
			}
		}
		return trouve ;
		
	}
	
	
	/**
	 * Recherche si le quota pour le type du document n'est pas dépassé pour l'abonné
	 * @param numeroAbo : numéro d'un abonné
	 * @param document : document
	 * @return true si le quota pour le type du document n'est pas dépassé sinon false
	 */
	public boolean quotaTypeNonDepasse(String numeroAbo, Document document){
		return true ;
	}
	
	/**
	 * Recherche si le document est disponible
	 * @param document 
	 * @return true si le document est disponible sinon false
	 */
	public boolean documentDisponible(Document document){
		
		return true;
	}
	
	//j'en suis iciiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii !!!!!!!!!!!!!!
}
