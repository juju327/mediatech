
public enum GenreLivre {
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
	
		
}
