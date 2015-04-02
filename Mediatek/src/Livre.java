import java.util.ArrayList;


public class Livre extends Document {
	private String numeroISBN ;
	private GenreLivre genre ;
	
	
	public Livre(String titre, String dateParution, String numeroISBN ,GenreLivre genre, ArrayList<Auteur> auteurs) {
		super(titre,dateParution, auteurs);
		setNumeroISBN(numeroISBN);
		setGenre(genre);
		createReference();
	}

	public String getNumeroISBN() {
		return numeroISBN;
	}

	private void setNumeroISBN(String numeroISBN) {
		this.numeroISBN = numeroISBN;
	}

	public GenreLivre getGenre() {
		return genre;
	}

	private void setGenre(GenreLivre genre) {
		this.genre = genre;
	}

	@Override
	protected void createReference() {
		newReference("L-"+getNumeroISBN()+"-"+getGenre()+"-"+getDateParution());	
	}
	
	
}
