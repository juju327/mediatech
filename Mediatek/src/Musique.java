import java.util.ArrayList;


public class Musique extends Document{
	private GenreMusique genre ;
	


	public Musique(String titre, String dateParution, GenreMusique genre, ArrayList<Auteur> auteurs) {
		super(titre, dateParution, auteurs);	
		setGenre(genre);
	}
	
	public GenreMusique getGenre() {
		return genre;
	}

	private void setGenre(GenreMusique genre) {
		this.genre = genre;
	}

	@Override
	public void createReference(String titre, String dateParution) {
		newReference("M-"+titre+"-"+genre+"-"+dateParution);	
		
	}
}
