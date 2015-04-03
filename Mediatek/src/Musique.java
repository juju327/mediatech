import java.util.ArrayList;

public class Musique extends Document {
	private GenreMusique genre;

	public Musique(String titre, String dateParution, GenreMusique genre,
			Auteur auteur) {
		super(titre, dateParution, auteur);
		setGenre(genre);
		createReference();
	}

	public GenreMusique getGenre() {
		return genre;
	}

	private void setGenre(GenreMusique genre) {
		this.genre = genre;
	}

	@Override
	protected void createReference() {
		newReference("M-" + getTitre() + "-" + getGenre() + "-"
				+ getDateParution());

	}
}
