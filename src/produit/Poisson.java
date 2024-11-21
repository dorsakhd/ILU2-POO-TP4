package produit;

public class Poisson extends Produit {
	String date;
	protected Poisson(String date) {
		super("poisson", Unite.PAR_PIECE);
		this.date = date;
	}
@Override
public String decrireProduit() {
	return getNom() + " peches " + date + getUnite();
}
}
