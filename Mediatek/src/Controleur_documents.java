import java.util.ArrayList;

public class Controleur_documents extends Controleur {

	public Controleur_documents(Mediatek mediatek) {
		super(mediatek);
	}
	
	/**
	 * ordonne à mediatek d'ajouter un livre à sa collection
	 * @param titre
	 * @param date
	 * @param numISBN
	 * @param genre
	 * @param auteurs
	 */
	public void creerLivre(String titre, String date, String numISBN,
			GenreLivre genre, ArrayList<Auteur> auteurs) {

		getMediatek().ajouterLivre(titre, date, numISBN, genre, auteurs);

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
			GenreMusique genre, ArrayList<Auteur> auteurs) {

		getMediatek().ajouterMusique(titre, dateParution, genre, auteurs);
	}
	
	public Document getDocument(String ref){
		return getMediatek().getDocuments().get(ref);
	}
}
