
public class Livre extends Document {
	private String numeroISBN ;
	private GenreLivre genre ;
	
	
	public Livre(String titre, String dateParution, String numeroISBN ,GenreLivre genre) {
		super(titre,dateParution);
		createReference(titre, dateParution);
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

	@Override
	public void createReference(String titre, String dateParution) {
		newReference("L-"+numeroISBN+"-"+genre+"-"+dateParution);	
	}
	
}
