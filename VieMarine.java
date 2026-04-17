//Class des VieMarine
public abstract class VieMarine {
    private String nom;
    private static int cpt = 0;
    private int id;

    public VieMarine(String nom) {
        this.nom = nom;
        this.id = cpt + 1;
        cpt++;
    }
    
    public String getNom() {
        return this.nom;
    }

    public int getTotalCreature() {
        return cpt;
    }

    public String toString() {
        return this.nom + " le " + this.id + " creature de la mer";
    }

    public abstract int getTotalChaque();
}