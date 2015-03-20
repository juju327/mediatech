
public class Parametres {
	
	private int quotaGlobal ;
	private int quotaLivre;
	private int quotaMusique ;
	private int tempsMaxLivre ;
	private int tempsMaxMusique;
	public Parametres(int quotaGlobal, int quotaLivre, int quotaMusique,
			int tempsMaxLivre, int tempsMaxMusique) {
		super();
		setQuotaGlobal(quotaGlobal); 
		setQuotaLivre(quotaLivre);
		setQuotaMusique(quotaMusique);
		setTempsMaxLivre(tempsMaxLivre);
		setTempsMaxMusique(tempsMaxMusique);
	}
	public int getQuotaGlobal() {
		return quotaGlobal;
	}
	private void setQuotaGlobal(int quotaGlobal) {
		this.quotaGlobal = quotaGlobal;
	}
	public int getQuotaLivre() {
		return quotaLivre;
	}
	private void setQuotaLivre(int quotaLivre) {
		this.quotaLivre = quotaLivre;
	}
	public int getQuotaMusique() {
		return quotaMusique;
	}
	private void setQuotaMusique(int quotaMusique) {
		this.quotaMusique = quotaMusique;
	}
	public int getTempsMaxLivre() {
		return tempsMaxLivre;
	}
	private void setTempsMaxLivre(int tempsMaxLivre) {
		this.tempsMaxLivre = tempsMaxLivre;
	}
	public int getTempsMaxMusique() {
		return tempsMaxMusique;
	}
	private void setTempsMaxMusique(int tempsMaxMusique) {
		this.tempsMaxMusique = tempsMaxMusique;
	}
	
	


	
	
	
}
