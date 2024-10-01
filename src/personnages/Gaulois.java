package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public String getNom() {
		return nom;
	}

	private int effetPotion = 1;

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return  "Le gaulois " + nom + " : ";
		
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merce Druide, je sens que ma force est " + Integer.toString(effetPotion) + " fois décuplée");
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] loot = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; loot != null && i < loot.length; i++) {
			trophees[nbTrophees] = loot[i];
			nbTrophees++;
		}
		
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparePotion();
		int force = panoramix.getForcePotion();

		if (panoramix.getForcePotion() <= 7) {
			System.out.println(
					"Je n'ai pas trouvé tous les ingrédients, ma potion est\n" + "seulement de force " + force);
		} else {
			System.out.println("J'ai préparé\n" + "une super potion de force " + force);
		}
		Romain romain = new Romain("Minnus", 10);
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		romain.parler("UN GAU");
		asterix.frapper(romain);

	}
}
