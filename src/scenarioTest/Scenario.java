package scenarioTest;

import personnages.Gaulois;
import villagegaulois.*;
import produit.*;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		
		IVillage village = new IVillage(){
            private IEtal[] marche = new IEtal[50];
            private int nbEtals = 0;
            public<P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix){
                if(!etal.getEtalOccupe()){
                    etal.installerVendeur(vendeur, produit, prix);
                    marche[nbEtals] = etal;
                    nbEtals++;
                    return true;
                }
                else{
                    return false;
                }
            }
            public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee){
                DepenseMarchand[] achats = new DepenseMarchand[50];
                int indiceDepenseMarchand = 0;
                int quantiteAchetee = 0;
                int i = 0;
                while((i<nbEtals)&&(quantiteAchetee<quantiteSouhaitee)){
                    int nbAchetes = marche[i].contientProduit(produit, quantiteSouhaitee-quantiteAchetee);
                    if(nbAchetes>0){
                        double prixPaye = marche[i].acheterProduit(nbAchetes);
                        DepenseMarchand dépense = new DepenseMarchand(marche[i].getVendeur(), nbAchetes, produit, prixPaye);
                        achats[indiceDepenseMarchand] = dépense;
                        indiceDepenseMarchand++;
                        quantiteAchetee+=nbAchetes;
                    }
                    i++;
                }
                return achats;
            }
            public String toString(){
                StringBuilder chaine = new StringBuilder();
                for(int i = 0 ; i<nbEtals ; i++){
                    chaine.append(marche[i].etatEtal());
                }
                return chaine.toString();
            }
        };

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		village.installerVendeur(etalSanglier1, obelix, sangliersObelix, 8);
		village.installerVendeur(etalSanglier2, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 7);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}