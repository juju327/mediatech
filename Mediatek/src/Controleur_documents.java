import java.util.ArrayList;


public class Controleur_documents extends Controleur {
	public boolean creerLivre(String titre, String date, String numISBN, GenreLivre genre, ArrayList<Auteur> auteurs) {
		
		// si les champs ne sont pas vides
		if(!titre.isEmpty() && !numISBN.isEmpty() && !auteurs.isEmpty()){
			// si la date est valide
			if(getMediatek().stringToDate(date) != null){
				getMediatek().ajouterLivre(titre, date, numISBN, genre, auteurs);
				return true;
			}
			
		}
		return false;
	}
}
