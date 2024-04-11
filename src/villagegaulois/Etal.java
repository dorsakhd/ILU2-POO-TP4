package villagegaulois;
import personnages.*;
import produit.*;

public class Etal<P extends Produit> implements IEtal {
	private Gaulois vendeur;
	P[] prods; //MARCHE GRACE A IProduit!
	int nbProduit;
	double prix;
	private boolean etalOccupe = false;
	
	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur = vendeur;
		this.prods = produit;
		this.prix = prix;
		this.nbProduit = produit.length;
		etalOccupe = true;
	}
	
	public Gaulois getVendeur() {
		return vendeur;
	}
	
	public double donnerPrix() {
		return prix;
	}
	
	public boolean getEtalOccupe() {
		return etalOccupe;
	}
	
	public double acheterProduit(int quantiteSouhaite) {
		double prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
		prixPaye += prods[i].calculerPrix(prix);
		}
		if (nbProduit >= quantiteSouhaite) {
		nbProduit -= quantiteSouhaite;
		} else {
		nbProduit = 0;
		}
		return prixPaye;
		}

	
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
		chaine.append(" vend ");
		chaine.append(nbProduit + " produits :");
		for (int i = 0; i < nbProduit; i++) {
		chaine.append("\n- " + prods[i].getDescription());
		}
		} else {
		chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
		}

	
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if ((nbProduit != 0 )&& (this.prods[0].getNom().equals(produit))) {
		if (nbProduit >= quantiteSouhaitee) {
		quantiteAVendre = quantiteSouhaitee;
		} else {
		quantiteAVendre = nbProduit;
		}
		}
		return quantiteAVendre;

	}
}