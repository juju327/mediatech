
import java.util.ArrayList;
import java.util.Date;

public abstract class AbstractFactory {

	public abstract Livre creerLivre(String titre, String dateParution,
			String numeroISBN, GenreLivre genre, Auteur auteur);

	public abstract Musique creerMusique(String titre, String dateParution,
			GenreMusique genre, Auteur auteur);

	public abstract Abonne creerAbonne(String nom, String prenom,
			String adresse, String dateNaissance);
}
