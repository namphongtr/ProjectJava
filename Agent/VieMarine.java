package Project.Agent;
//Class des VieMarine
public abstract class VieMarine extends Agent {
    private static int cpt = 0;
    private final int id;

    public VieMarine(Terrain t, int lig, int col) {
        super(t, lig, col);
        this.id = ++cpt;
    }
    
    public VieMarine(Terrain t) {
        super(t);
        this.id = ++cpt;
    }

    public static int getTotalCreature() {
        return cpt;
    }

    public String toString() {
        return "Le " + this.id + " creature de la mer";
    }

    public abstract void donnerNaissance(Terrain t);
}