package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random rand = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom 
				+ " et ma potion peut aller d'une force " + effetPotionMin 
				+ " � " + effetPotionMax + ".");
	}
	
	public void preparerPotion() {
		parler("Je vais aller me pr�parer une petite potion...");
		forcePotion = rand.nextInt(effetPotionMax - effetPotionMin +1)+effetPotionMin;
		if (forcePotion>7) {
			parler("J'ai pr�par� une super potion de force " + forcePotion);
		}
		else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion);
		}
	}
		
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	public void booster (Gaulois gaulois) {
		if (gaulois.getNom()=="Ob�lix") {
			parler("Non, Ob�lix!... Tu n'auras pas de potion magique!");
		}
		else {
			gaulois.boirePotion(forcePotion);
			forcePotion = 0;
		}
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
}
