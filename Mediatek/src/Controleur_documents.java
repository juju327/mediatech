import java.util.ArrayList;


public class Controleur_documents extends Controleur {
	public void creerLivre(String titre, String date, String numISBN, GenreLivre genre, ArrayList<Auteur> auteurs) {
		getMediatek().ajouterLivre(titre, date, numISBN, genre, auteurs);		
	}
}
