package produit;

public class Poisson extends Produit {
	
	private String date;

	public Poisson(String date) {
		super("poisson", Unite.PAR_PIECE);
		this.date = date;
	}
	@Override
	public String decrireProduit() {
	    return getNom() + " pêché " + date;
	}

}
