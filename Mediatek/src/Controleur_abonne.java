import java.util.Date;
import java.util.Map.Entry;

public class Controleur_abonne extends Controleur {

	public Controleur_abonne(Mediatek mediatek) {
		super(mediatek);
	}

	/**
	 * Recherche si le numéro d'abonné passé en paramètre appartient à la liste
	 * des abonnés de la médiatech.
	 * 
	 * @param numeroAbo
	 *            : numéro d'un abonné
	 * @return true si le numéro d'abonné existe sinon false
	 */
	public Abonne numeroAbonneValide(String numeroAbo) {
		return getMediatek().getAbonnes().get(numeroAbo);
	}

	/**
	 * Recherche s'il existe une abonné associée au nom et au prénom saisis
	 * 
	 * @param nom
	 *            String
	 * @param prenom
	 *            String
	 * @return Abonne abonne
	 */
	public Abonne rechercheAboParNomPrenom(String nom, String prenom) {
		Abonne trouve = null;
		for (Entry<String, Abonne> entry : getMediatek().getAbonnes()
				.entrySet()) {
			if (entry.getValue().getNom().toLowerCase().contains(nom)
					&& (entry.getValue().getNom().toLowerCase()
							.contains(prenom))) {
				trouve = entry.getValue();
			}
		}
		return trouve;
	}

	/**
	 * ordonne à mediatek d'ajouter un abonné à sa collection
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param dateN
	 * @return
	 */
	public String creerAbonne(String nom, String prenom, String adresse,
			String dateN) {
		return getMediatek().ajouterAbonne(nom, prenom, adresse, dateN);
		
	}
	
	/**
	 * 
	 * @param num
	 * @return l'abonné de numéro num
	 */
	public Abonne getAbonne(String num) {
		return (getMediatek().getAbonnes().get(num));
	}
}
