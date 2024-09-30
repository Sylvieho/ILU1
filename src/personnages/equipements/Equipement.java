package personnages.equipements;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipement(String chaine) {
		this.nom = chaine;
	}
	
	public String toString() {
		return nom;
	}
	
}

