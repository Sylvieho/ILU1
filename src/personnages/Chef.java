package personnages;

import lieux.Village;

public class Chef {
	private String nom;
	private int force;
	private Village village;

	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " +
				romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	public String getNom() {
		return nom;
	}
}
