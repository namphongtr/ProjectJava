//Class des VieMarine
public abstract class VieMarine extends Agent {
    private static int cpt = 0;
    private final int id;
    

    public VieMarine(Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.id = ++cpt;
    }
    
    public VieMarine(Terrain t, Simulation s) {
        super(t, s);
        this.id = ++cpt;
    }

    public static int getTotalCreature() {
        return cpt;
    }

    public String toString() {
        return "Le " + this.id + " creature de la mer";
    }

    public abstract void donnerNaissance();
    public abstract void agir();


}