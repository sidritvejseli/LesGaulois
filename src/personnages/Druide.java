package personnages;

import java.util.Random;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public void preparePotion() {
		Random objet = new Random();
		this.forcePotion = objet.nextInt((this.effetPotionMax - this.effetPotionMin) + 1) + this.effetPotionMin;
//		this.effetPotionMin

	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			System.out.println("Non, Obélix !... Tu n’auras pas de potion\n"
					+ "magique !");
		}
		else {
			gaulois.boirePotion(getForcePotion());
		}
	}


	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain romain = new Romain("romain", 10);
		System.out.println(panoramix);

		panoramix.preparePotion();
		int force = panoramix.getForcePotion();}
	}


