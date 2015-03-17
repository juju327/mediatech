
public class Musique extends Document{
	private GenreMusique genre ;
	


	public Musique(String titre, String dateParution, String reference,
			int dureeMax, int nbMax,GenreMusique genre) {
		super(titre, dateParution, reference, dureeMax, nbMax);
		
		setGenre(genre);
	}
	
	public GenreMusique getGenre() {
		return genre;
	}

	private void setGenre(GenreMusique genre) {
		this.genre = genre;
	}
}
