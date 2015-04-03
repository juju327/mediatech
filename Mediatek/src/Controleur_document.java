import java.util.ArrayList;

public class Controleur_document extends Controleur {

	public Controleur_document(Mediatek mediatek) {
		super(mediatek);
	}

	/**
	 * ordonne à mediatek d'ajouter un livre à sa collection
	 * 
	 * @param titre
	 * @param date
	 * @param numISBN
	 * @param genre
	 * @param auteurs
	 */
	public void creerLivre(String titre, String date, String numISBN,
			GenreLivre genre, Auteur auteur) {

		getMediatek().ajouterLivre(titre, date, numISBN, genre, auteur);
		save();
	}

	public boolean numISBNExiste(String num) {
		for (Document d : getMediatek().getDocuments().values()) {
			if (d.getClass() == Livre.class) {
				Livre l = (Livre) d;
				if (l.getNumeroISBN().equals(num)) {
					return true;
				}
			}
		}
		return false;
	}

	public void creeMusique(String titre, String dateParution,
			GenreMusique genre, Auteur auteur) {

		getMediatek().ajouterMusique(titre, dateParution, genre, auteur);
		save();
	}

	public Document getDocument(String ref) {
		return getMediatek().getDocuments().get(ref);
	}

	public void supprimerDocument(String refDoc) {
		getMediatek().supprimerDocument(getDocument(refDoc));
		save();
	}

	public boolean estDispo(String refDoc) {
		return getDocument(refDoc).isDisponible();
	}

	public boolean musicExiste(String titre, Auteur auteur) {
		for (Document d : getMediatek().getDocuments().values()) {
			if (d.getTitre().equals(titre)
					&& d.getAuteur().getNom().equals(auteur.getNom())) {
				return true;
			}
		}
		return false;
	}
}
