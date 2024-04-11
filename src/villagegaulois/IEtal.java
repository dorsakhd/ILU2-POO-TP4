package villagegaulois;
import personnages.*;
public interface IEtal {
	Gaulois getVendeur();
	double donnerPrix();
	int contientProduit(String produit, int quantiteSouhaitee);
	double acheterProduit(int quantiteSouhaitee);
	String etatEtal();
}