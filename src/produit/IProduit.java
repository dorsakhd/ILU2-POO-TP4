package produit;

public interface IProduit {

	String getNom();

	String decrireProduit();

	Unite getUnite();
	
	default int calculerPrix(int prix) {
		return prix;
	}
	

}