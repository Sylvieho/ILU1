package personnages;

import personnages.equipements.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int avantCoup = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force>=avantCoup;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 0:
			equiperObjet(equipement, 0);
			break;
		case 1:
			if (equipements[0]!= null && equipement.equals(equipements[0])) {
				System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement + " !");
			} else {
				equiperObjet(equipement, 1);
			}
			break;
		case 2 :
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		default:
			break;
		}
	}
	
	private void equiperObjet(Equipement equipement, int i) {
		System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement + ".");
		equipements[i] = equipement;
		nbEquipement++;
		
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);
	}
}
