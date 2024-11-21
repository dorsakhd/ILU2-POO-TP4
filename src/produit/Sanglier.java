package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	
	int poids;
	
	Gaulois chasseur;
	protected Sanglier(int poids, Gaulois chasseur) {
		super("sanglier",Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	public String  decrireProduit() {
		return getNom() + " de " + poids + getUnite()+ " chassé par " + chasseur.getNom();
	}
}
