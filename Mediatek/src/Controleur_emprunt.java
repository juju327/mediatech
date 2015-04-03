import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;

public class Controleur_emprunt extends Controleur {

	public Controleur_emprunt(Mediatek mediatek) {
		super(mediatek);
	}

	/**
	 * Recherche si le quota pour le type du document n'est pas dépassé pour
	 * l'abonné
	 * 
	 * @param numeroAbo
	 *            : numéro d'un abonné
	 * @param document
	 *            : document
	 * @return true si le quota pour le type du document n'est pas dépassé sinon
	 *         false
	 */
	/*
	 * public boolean quotaTypeNonDepasse(String numeroAbo, Document document){
	 * return true ; }
	 */

	/**
	 * Recherche si le document est disponible
	 * 
	 * @param document
	 * @return true si le document est disponible sinon false
	 */
	public boolean isDocumentDisponible(String ref) {
		if (getMediatek().getDocuments().get(ref).isDisponible()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recherche si le quota globale (nombre total d'emprunt) de l'abonné n'est
	 * pas dépassé grâce à la liste d'emprunt
	 * 
	 * @param numeroAbo
	 *            : numéro d'un abonné
	 * @return true si le quota global n'est pas dépassé sinon false
	 */
	public boolean quotaGlobalNonDepasse(Abonne abo) {
		if (abo.getEmprunts().size() > getMediatek().getParametres()
				.getQuotaGlobal()) {
			return false;
		} else {
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
	public void faireEmprunt(Document doc, Abonne abonne) {
		Date dateJour = new Date();

		Date dateRetour = addToDate(new Date(), getMediatek().getParametres()
				.getTempsMaxLivre());

		Emprunt emprunt = new Emprunt(doc, abonne, dateJour, dateRetour);
		abonne.emprunter(emprunt);
		getMediatek().addEmprunt(emprunt);
		emprunt.getPret().setDisponible(false);
		save();
	}

	/**
	 * retourne un document d'un abonné
	 * 
	 * @param reference
	 *            la référence du document à rendre
	 */
	public void faireRetour(String reference) {
		Emprunt emprunt = getEmprunt(reference);
		emprunt.getPret().setDisponible(true);
		emprunt.getEmprunteur().rendre(emprunt);
		getMediatek().remove(emprunt);
		save();
	}

	/**
	 * 
	 * @param refDoc
	 * @param abonne
	 * @return true si l'emprunt peut être réalisé
	 */
	public boolean verifEmprunt(String refDoc, Abonne abonne) {
		return (referenceDocumentValide(refDoc) && quotaGlobalNonDepasse(abonne));
	}

	/**
	 * 
	 * @param refDoc
	 * @return vérifie que le document est bien emprunté, et que le document
	 *         existe
	 */
	public boolean verifRetour(String refDoc) {
		return (referenceDocumentValide(refDoc) && !isDocumentDisponible(refDoc));
	}

	/**
	 * 
	 * @param reference
	 * @return un emprunt correspondant à la référence, null sinon
	 */
	private Emprunt getEmprunt(String reference) {
		for (Emprunt e : getMediatek().getEmprunts()) {
			if (e.getPret().getReference().equals(reference)) {
				return e;
			}
		}
		return null;
	}

	public ArrayList<Emprunt> getAllEmprunts() {
		return (getMediatek().getEmprunts());
	}

}
