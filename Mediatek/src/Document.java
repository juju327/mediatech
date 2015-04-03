import java.io.Serializable;
import java.util.ArrayList;

public abstract class Document implements Serializable {
	private String titre;
	private String dateParution;
	private String reference;
	private boolean disponible;
	private Auteur auteur;

	public Document(String titre, String dateParution, Auteur auteur) {
		setTitre(titre);
		setDateParution(dateParution);
		setDisponible(true);
		setAuteur(auteur);
	}

	public Auteur getAuteur() {
		return auteur;
	}

	private void setAuteur(Auteur auteur) {
		auteur.addAPublie(this);
		this.auteur = auteur;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTitre() {
		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDateParution() {
		return dateParution;
	}

	private void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}

	public String getReference() {
		return reference;
	}

	private void setReference(String reference) {
		this.reference = reference;
	}

	public void newReference(String reference) {
		setReference(reference);
	}

	protected abstract void createReference();

	public abstract Genre getGenre();

}
