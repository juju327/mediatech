
import java.io.Serializable;


public enum GenreLivre implements Serializable, Genre{
	Roman ("Roman"),
	BD ("BD"),
	Documentaire ("Documentaire"),
	Manga ("Manga"),
	Jeunesse ("Jeunesse");
	
	private String name = "";
	
	GenreLivre(String genre){
		this.name = genre;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public GenreLivre getGenre(){
		return this;
	}
	
		
}
