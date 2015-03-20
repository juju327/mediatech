
public class ConcreteFactory extends AbstractFactory {

	@Override
	public Livre creerLivre(String titre, String dateParution, String numeroISBN ,GenreLivre genre) {
		
		Livre livre = new Livre(titre, dateParution, numeroISBN , genre);
		return livre;
	}

	@Override
	public Musique creerMusique(String titre, String dateParution, GenreMusique genre) {
		Musique musique = new Musique(titre, dateParution, genre);
		return musique;
	}

}
