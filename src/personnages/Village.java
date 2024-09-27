package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}


	public Village(String nom) {
		this.nom = nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}


	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois += 1;
		}
	}

	public Gaulois trouverHabitant(int numero_v) {
		return villageois[numero_v];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef" + chef.getNom() + "vivent les légendaires gaulois : ");
		for (int i = 0; i<nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		Chef abraracoursix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		village.setChef(abraracoursix);
		village.afficherVillageois();
	}

}