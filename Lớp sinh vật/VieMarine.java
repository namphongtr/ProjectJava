//Class des VieMarine
public abstract class VieMarine {
    private String nom;
    private static int cpt = 0;
    private final int id;

    public VieMarine(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
        throw new IllegalArgumentException("Le nom ne peut pas laisser vide");
    }
    this.nom = nom.trim();
    this.id = ++cpt;
    }
    
    public String getNom() {
        return this.nom;
    }

    public static int getTotalCreature() {
        return cpt;
    }

    public String toString() {
        return this.nom + " le " + this.id + " creature de la mer";
    }
}