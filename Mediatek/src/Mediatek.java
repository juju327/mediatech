import java.util.ArrayList;


public class Mediatek {

	private ArrayList<Document> documents;

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	private void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	/**
	 * Rend le document de référence ref
	 * @param ref la référence à trouver
	 * @return le document de référence ref si il existe dans la médiathèque, null sinon.
	 */
	public Document getDocumentByRef(String ref){
		for(Document d : this.documents){
			if(d.getReference().equals(ref)){
				return d;
			}
		}
		return null;
	}
	
	
	/**
	 * emprunte un document pour un abonné
	 * @param refDoc la référence du document à emprunter
	 * @param numAb le numéro de l'abonné
	 */
	public void faireEmprunt(String refDoc, String numAb){
		Document doc = getDocumentByRef(refDoc);
		//Abonné abonne = 
	}
	
	
}
