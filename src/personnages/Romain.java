package personnages;

import personnages.equipements.Equipement;

public class Romain {
	private String nom;
	private int force;
	private String texte;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String soldat = "Le soldat";

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		if (force<=0) {
			 throw new IllegalArgumentException("Invalid force: " + force);
		}
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

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int avantCoup = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force>=avantCoup;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
			// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else	{
					if(equipements[i].equals(Equipement.CASQUE)){
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement && equipements[i] == null; i++) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		return equipementEjecte;
	}


	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 0:
			equiperObjet(equipement, 0);
			break;
		case 1:
			if (equipements[0]!= null && equipement.equals(equipements[0])) {
				System.out.println(soldat + getNom() + " possède déjà un " + equipement + " !");
			} else {
				equiperObjet(equipement, 1);
			}
			break;
		case 2 :
			System.out.println(soldat + getNom() + " est déjà bien protégé !");
			break;
		default:
			break;
		}
	}
	
	private void equiperObjet(Equipement equipement, int i) {
		System.out.println(soldat + getNom() + " s'équipe avec un " + equipement + ".");
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

	public int getForce() {
		return force;
	}
}
