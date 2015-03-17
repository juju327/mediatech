
public class Livre extends Document {
	private String numeroISBN ;
	private GenreLivre genre ;
	
	
	public Livre(String titre, String dateParution, String reference,
			int dureeMax, int nbMax, String numeroISBN ,GenreLivre genre) {
		super(titre, dateParution, reference, dureeMax, nbMax);
		
		setNumeroISBN(numeroISBN);
		setGenre(genre);
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
	
}
