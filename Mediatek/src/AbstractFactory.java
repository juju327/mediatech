
public abstract class AbstractFactory {
	
	public abstract Livre creerLivre(String titre, String dateParution, String numeroISBN ,GenreLivre genre);
	
	public abstract Musique creerMusique(String titre, String dateParution, GenreMusique genre);
}
