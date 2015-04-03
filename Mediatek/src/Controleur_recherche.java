import java.util.ArrayList;
import java.util.HashMap;

public class Controleur_recherche extends Controleur {

	public Controleur_recherche(Mediatek mediatek) {
		super(mediatek);
	}

	/**
	 * Recherche si la référence passée existe dans la liste de document de la
	 * mediatek
	 * 
	 * @param reference
	 *            : String : une reference de livre
	 * @return Document correspondant à la reference
	 */
	public HashMap<String, Document> rechercheParReference(String reference) {
		HashMap<String, Document> trouve = new HashMap<String, Document>();
		trouve.put(reference, getMediatek().getDocuments().get(reference));
		return trouve;
	}

	/**
	 * Recherche si les mots passées sont contenus dans un ou plusieurs titres
	 * de livres de la médiatek
	 * 
	 * @param mots
	 *            : String : chaine à rechercher dans les titres
	 * @return ArrayList<String> : le titre des documents contenant mots
	 */
	public ArrayList<Document> rechercheParTitre(String mots) {
		mots = mots.toLowerCase();
		ArrayList<Document> documents = new ArrayList<>();

		for (Document d : getMediatek().getDocuments().values()) {
			if (d.getTitre().toLowerCase().contains(mots)) {
				documents.add(d);
			}
		}
		return documents;
	}

	public HashMap<String, Document> rechercheParNationalite(String nationalite) {
		nationalite = nationalite.toLowerCase();
		HashMap<String, Document> trouve = new HashMap<String, Document>();

		ArrayList<Auteur> lesauteurs = getMediatek().getAuteurs();
		for (Auteur a : lesauteurs) {
			if (a.getNationalité().contains(nationalite.toLowerCase())) {
				ArrayList<Document> lesdocs = getMediatek().getAuteurs()
						.get(getMediatek().getAuteurs().indexOf(a))
						.getAPublie();
				for (Document d : lesdocs) {
					trouve.put(d.getReference(), d);
				}
			}
		}
		return trouve;
	}

	/**
	 * 
	 * @param auteur
	 * @return la liste des documents publiés par l'auteur auteur
	 */
	public ArrayList<Document> rechercheParNomAuteur(String auteur) {
		for (Auteur a : getMediatek().getAuteurs()) {
			if (a.getNom().toLowerCase().contains(auteur.toLowerCase())) {
				return a.getAPublie();
			}
		}
		return null;
	}

}
