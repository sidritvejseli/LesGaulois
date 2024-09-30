package personnages;

public class Romain {
	private String nom;
	private int force;
	int nbEquipement ;
	private Equipement[] equipements;

	public Romain(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert (force > 0);
		int force_init = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (force < force_init);//postcondition 
	}
	
	
	    public void sEquiper(Equipement equipement) {
	        switch (nbEquipement) {
	            case 2:
	            	 System.out.println("Le soldat " + nom + " est déjà bien protégé !");
	                break;
	            case 1:
	                if (equipements[0] == equipement) {
	                	System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	                } else {
	                	equipements[nbEquipement] = equipement;
	                    nbEquipement++;
	                    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	                }
	                break;
	            case 0:
	            	equipements[nbEquipement] = equipement;
	                nbEquipement++;
	                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	                break;
	        }
	    }
	public static void main(String args[]) {
		Romain romain = new Romain("minus", 6);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		
	}
}
