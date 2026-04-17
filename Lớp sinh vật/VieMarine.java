//Class des VieMarine
public abstract class VieMarine {
    private static int cpt = 0;
    private final int id;

    public VieMarine() {
    this.id = ++cpt;
    }
    

    public static int getTotalCreature() {
        return cpt;
    }

    public String toString() {
        return "Le " + this.id + " creature de la mer";
    }

    public abstract void donnerNaissance();
}