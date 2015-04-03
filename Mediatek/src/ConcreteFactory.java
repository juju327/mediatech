import java.util.Date;
import java.util.ArrayList;

public class ConcreteFactory extends AbstractFactory {

	@Override
	public Livre creerLivre(String titre, String dateParution,
			String numeroISBN, GenreLivre genre, Auteur auteur) {

		Livre livre = new Livre(titre, dateParution, numeroISBN, genre, auteur);
		return livre;
	}

	@Override
	public Musique creerMusique(String titre, String dateParution,
			GenreMusique genre, Auteur auteur) {
		Musique musique = new Musique(titre, dateParution, genre, auteur);
		return musique;
	}

	@Override
	public Abonne creerAbonne(String nom, String prenom, String adresse,
			String dateNaissance) {
		Abonne abo = new Abonne(nom, prenom, adresse, dateNaissance);
		return abo;
	}
}
