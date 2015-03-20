import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Mediatek {

	private ArrayList<Document> documents;
	private ArrayList<Abonné> abonnes;
	private ArrayList<Emprunt> emprunts;
	
	private int quotaGlobal = 6;
	
	

	public int getQuotaGlobal() {
		return quotaGlobal;
	}

	private void setQuotaGlobal(int quotaGlobal) {
		this.quotaGlobal = quotaGlobal;
	}

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
	public void faireEmprunt(Document doc, Abonné abonne){
		Date dateJour = new Date();
		Date dateRetour = new Date();	
		
		int nbJours = doc.getDureeMax();

		Calendar c = Calendar.getInstance();
		c.setTime(dateRetour);
		c.add(Calendar.DAY_OF_MONTH, nbJours);  
		dateRetour = c.getTime();		
		
		Emprunt emprunt = new Emprunt(doc, abonne, dateJour, dateRetour);
		abonne.emprunter(emprunt);
		emprunts.add(emprunt);
	}
	
	/**
	 * retourne un document d'un abonné
	 * @param refDoc la référence du document à rendre
	 * @param numAb le numéro de l'abonné
	 */
	public void faireRetour(Document doc, Abonné abonne){
		
		//emprunt
		//abonne.rendre(emprunt);
		//emprunts.add(emprunt);
		
		//abonne.rendre(doc);
	}
	
	
	
	
	
	
	
}
