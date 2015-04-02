import java.util.ArrayList;


public class Controleur_documents extends Controleur {
	
	public boolean creerLivre(String titre, String date, String numISBN, GenreLivre genre, ArrayList<Auteur> auteurs) {
		
		// si les champs ne sont pas vides
		if(!titre.isEmpty() && !numISBN.isEmpty() && !numISBNExiste(numISBN) && !auteurs.isEmpty()){
			// si la date est valide
			if(getMediatek().stringToDate(date) != null){
				getMediatek().ajouterLivre(titre, date, numISBN, genre, auteurs);
				return true;
			}
			
		}
		return false;
	}
	
	public Controleur_documents(Mediatek mediatek){
		super(mediatek);
		
	}
	
	public boolean numISBNExiste(String num){
		for(Document d :getMediatek().getDocuments().values()){
			if(d.getClass() == Livre.class){
				Livre l = (Livre) d;
				if( l.getNumeroISBN().equals(num) ){
					return true;
				}
			}
		}
		return false;
	}
	
	public void save(){
		getMediatek().saveDB();
	}
}
