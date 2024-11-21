package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal {


	int contientProduit(String produit, int quantiteSouhaitee);

	int acheterProduit(int quantiteSouhaite);

	String etatEtal();

}