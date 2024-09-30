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

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain romain = new Romain("romain", 10);
		System.out.println(panoramix);

		panoramix.preparePotion();
		int force = panoramix.getForcePotion();
		if (panoramix.forcePotion <= 7) {
			System.out.println(
					"Je n'ai pas trouvé tous les ingrédients, ma potion est\n" + "seulement de force " + force);
		} else {
			System.out.println("J'ai préparé\n" + "une super potion de force " + force);
		}
	}

}
