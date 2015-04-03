import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

public abstract class Controleur {
	private Mediatek mediatek;

	public Controleur(Mediatek mediatek) {
		setMediatek(mediatek);
	}

	protected Mediatek getMediatek() {
		return mediatek;
	}

	private void setMediatek(Mediatek mediatek) {
		this.mediatek = mediatek;
	}

	/**
	 * ajoute jours à la date date
	 * 
	 * @param date
	 *            la date à laquelle ajouter les jours
	 * @param jours
	 *            le nombre de jours à ajouter
	 * @return la nouvelle date
	 */
	public Date addToDate(Date date, int jours) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, jours);
		date = c.getTime();
		return date;
	}

	/**
	 * 
	 * @param date
	 *            la date à transformer en string
	 * @return une string représentant la date
	 */
	public String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param d
	 *            la string représentant une date à transformer en date
	 * @return une date issue de la string donnée, null sinon
	 */
	public Date stringToDate(String d) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = d;
		Date date = new Date();

		date = formatter.parse(dateInString);

		return date;
	}

	/**
	 * vérifie si la date saisie est bien un format valide
	 * 
	 * @param date
	 * @return true si la date est valide, false sinon
	 */
	public boolean verifDate(String date) {
		try {
			stringToDate(date);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void save() {
		getMediatek().saveDB();
	}

	/**
	 * Recherche parmi la liste des documents si la référence existe
	 * 
	 * @param reference
	 *            : reference d'un document
	 * @return true si la référence existe sinon false
	 */

	public boolean referenceDocumentValide(String reference) {
		return getMediatek().getDocuments().containsKey(reference);
	}

}
