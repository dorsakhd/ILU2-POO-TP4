package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<P extends IProduit> implements IEtal {
	private Gaulois vendeur;
	private P[] produits;
	private int nbProduit;
	private int prix;

	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur = vendeur;
		this.produits = produit;
		this.nbProduit = produit.length;
		this.prix = prix;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
	    int quantiteAVendre = 0;
	    for (int i = 0; i < nbProduit; i++) {
	        if (produits[i].getNom().equals(produit)) {
	            if (nbProduit >= quantiteSouhaitee) {
	                quantiteAVendre = quantiteSouhaitee;
	            } else {
	                quantiteAVendre = nbProduit;
	            }
	        }
	    }
	    return quantiteAVendre;
	}


	@Override
	public int acheterProduit(int quantiteSouhaite) {
	    int prixPaye = 0;

	    for (int i = 0; i < quantiteSouhaite; i++) {
	        prixPaye += produits[nbProduit - 1 - i].calculerPrix(prix); 
	    }
	    nbProduit -= quantiteSouhaite;
	    if (nbProduit < 0) {
	        nbProduit = 0;  
	    }

	    return prixPaye;
	}




	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produits[i].decrireProduit());
			}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}
}
