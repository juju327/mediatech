import java.util.ArrayList;


public abstract class AbstractFactory {
	
	public abstract Livre creerLivre(String titre, String dateParution, String numeroISBN ,GenreLivre genre, ArrayList<Auteur> auteurs);
	
	public abstract Musique creerMusique(String titre, String dateParution, GenreMusique genre, ArrayList<Auteur> auteurs);
}
