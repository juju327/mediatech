

import java.util.ArrayList;
import java.util.Date;


public abstract class AbstractFactory {
	
	public abstract Livre creerLivre(String titre, String dateParution, String numeroISBN ,GenreLivre genre, ArrayList<Auteur> auteurs);
	
	public abstract Musique creerMusique(String titre, String dateParution, GenreMusique genre, ArrayList<Auteur> auteurs);
	
	public abstract Abonné creerAbonne(String nom, String prenom, String adresse, Date dateNaissance, String numeroAbo);
}
