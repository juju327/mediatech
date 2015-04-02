import java.util.HashMap;


public class Controleur_Recherche extends Controleur{

	public Controleur_Recherche(Mediatek mediatek) {
		super(mediatek);	
	}
	
	/**
	 * Recherche si la référence passée existe dans la liste de document de la mediatek
	 * @param reference : String : une reference de livre
	 * @return Document correspondant à la reference
	 */
	public Document rechercheParReference(String reference){
		return getMediatek().getDocuments().get(reference) ;
	}
	
	/**
	 * Recherche si les mots passées sont contenus dans un ou plusieurs titres de livres de la médiatek
	 * @param mots : String : chaine à rechercher dans les titres
	 * @return HashMap<String,Document> : les documents dont le titre contient mots (ou null)
	 */
	public HashMap<String,Document> rechercheParTitre(String mots){
		HashMap<String,Document> trouve = new HashMap<String, Document>();
		 getMediatek().getDocuments() ;
		for (HashMap.Entry<String, Document> entry : getMediatek().getDocuments().entrySet()) {
			if(entry.getValue().getTitre().contains(mots)){
				trouve.put(entry.getKey(), entry.getValue());
			}
		}
		return trouve ;
	}
	

}
