package lieux;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Gaulois[] villageois;
	private Chef chef;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum] ;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public String getNom() {
		return nom;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans " + getNom() + " du chef " + chef.getNom() + "vivent les légendaires gaulois :");
		for(int i = 0; i<nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30); car dans le tableau l'indice 30 correspond au 31e
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
}
