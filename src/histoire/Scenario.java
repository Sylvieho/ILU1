package histoire;

import java.util.Iterator;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain minus = new Romain("Minus", 6);
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		panoramix.booster(asterix);;
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);			
		
	}

}
