package produit;

public abstract class Produit implements IProduit {
	private String nom;
	public Unité unité;
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public abstract String getDescription();
	public Produit(String nom, Unité unité) {
		this.nom = nom;
		this.unité = unité;
	}
	public abstract double calculerPrix(double prix);
}