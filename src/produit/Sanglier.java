package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	
	private int poid;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier",Unite.KILOGRAMME);
		this.poid = poids;
		this.chasseur = chasseur;
	}
	@Override
	public String decrireProduit() {
	    return getNom() + " de " + poid + " kg chassé par " + chasseur.getNom();
	}
	@Override
	public int calculerPrix(int prix) {
		return (prix * poid) / 1000; 
	}
	

}
