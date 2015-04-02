import java.io.Serializable;


public enum GenreMusique implements Serializable {
	Rock ("Rock"),
	Jazz ("Jazz"),
	Classique ("Classique"),
	Pop ("Pop"),
	Rap ("Rap"),
	Autre ("Rap");
	
	private String name = "";
	
	private GenreMusique(String genre){
		this.name = genre;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
