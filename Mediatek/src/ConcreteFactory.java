
import java.util.Date;
import java.util.ArrayList;

public class ConcreteFactory extends AbstractFactory {

	@Override
	public Livre creerLivre(String titre, String dateParution,
			String numeroISBN, GenreLivre genre, ArrayList<Auteur> auteurs) {

		Livre livre = new Livre(titre, dateParution, numeroISBN, genre, auteurs);
		return livre;
	}

	@Override
	public Musique creerMusique(String titre, String dateParution,
			GenreMusique genre, ArrayList<Auteur> auteurs) {
		Musique musique = new Musique(titre, dateParution, genre, auteurs);
		return musique;
	}

	@Override
	public Abonne creerAbonne(String nom, String prenom, String adresse,
			String dateNaissance) {
		Abonne abo = new Abonne(nom, prenom, adresse, dateNaissance);
		return abo;
	}
}
