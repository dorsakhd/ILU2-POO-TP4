package produit;

public class Poisson extends Produit {
	String date;
	public Poisson(String date) {
		super("poisson", Unité.KILOGRAMME);
		this.date = date;
	}
	public String getDescription() {
		return getNom() + " p�ch�s " + date;
	}
	public double calculerPrix(double prix) {
		return prix;
	}
}