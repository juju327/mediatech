import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

public abstract class Controleur {
	private Mediatek mediatek;

	public Mediatek getMediatek() {
		return mediatek;
	}

	private void setMediatek(Mediatek mediatek) {
		this.mediatek = mediatek;
	}

	public Controleur(Mediatek mediatek) {
		setMediatek(mediatek);
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
	 * Recherche si le numéro d'abonné passé en paramètre appartient à la liste des abonnés de la médiatech.
	 * @param numeroAbo : numéro d'un abonné
	 * @return true si le numéro d'abonné existe sinon false
	 */
	public Abonné numeroAbonneValide(String numeroAbo){
		return mediatek.getAbonnes().get(numeroAbo) ;
	}
	
	/**
	 * Recherche s'il existe une abonné associée au nom et au prénom saisis
	 * @param nom String 
	 * @param prenom String
	 * @return Abonné abonne
	 */
	public Abonné rechercheAboParNomPrenom(String nom, String prenom){
		Abonné trouve = null;
		for (Entry<String, Abonné> entry : getMediatek().getAbonnes().entrySet()) {
			if(entry.getValue().getNom().toLowerCase().contains(nom) && (entry.getValue().getNom().toLowerCase().contains(prenom))){
				trouve=entry.getValue();
			}
		}
		return trouve;
	}
}
