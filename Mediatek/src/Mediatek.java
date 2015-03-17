import java.util.ArrayList;
import java.util.Date;


public class Mediatek {

	private ArrayList<Document> documents;
	private ArrayList<Abonné> abonnes;

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public ArrayList<Abonné> getAbonnes() {
		return abonnes;
	}

	private void setAbonnes(ArrayList<Abonné> abonnes) {
		this.abonnes = abonnes;
	}

	private void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	/**
	 * rend le document de référence ref
	 * @param ref la référence à trouver
	 * @return le document de référence ref s'il existe dans la médiathèque, null sinon.
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
	 * rend l'abonné de numéro num
	 * @param num le numéro de l'abonné à trouver
	 * @return l'abonné de numéro num s'il existe, null sinon
	 */
	public Abonné getAbonneByNum(String num){
		for(Abonné a : this.abonnes){
			if(a.getNumero().equals(num)){
				return a;
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
		Abonné abonne = getAbonneByNum(numAb);
		Date dateJour;
		Date dateRetour; // = dateJour + doc.getDuree
		//Emprunt emprunt = new Emprunt(dateJour, dateRetour, )
		//abonne.emprunter(doc);
	}
	
	/**
	 * retourne un document d'un abonné
	 * @param refDoc la référence du document à rendre
	 * @param numAb le numéro de l'abonné
	 */
	public void faireRetour(String refDoc, String numAb){
		Document doc = getDocumentByRef(refDoc);
		Abonné abonne = getAbonneByNum(numAb);
		
		//abonne.rendre(doc);
	}
	
	
	
	
}
