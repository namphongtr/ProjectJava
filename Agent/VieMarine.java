/*Class des VieMarine extends de la classe Agent qui determiner total de creature dans la mer */
public abstract class VieMarine extends Agent {
    private static int cpt = 0;
    private final int id;

    /* Construction */
    public VieMarine(Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.id = ++cpt;
    }

    /* Construction */
    public VieMarine(Terrain t, Simulation s) {
        super(t, s);
        this.id = ++cpt;
    }

    /* Methode pour prend total creature dans la mer */
    public static int getTotalCreature() {
        return cpt;
    }

    /* Methode pour afficher */
    public String toString() {
        return "Le " + this.id + " creature de la mer";
    }

    /* Methode abstract donner naissance */
    public abstract void donnerNaissance();

    /*
     * Methode abstract decide comment ils se déplacent, chassent et se reproduisent
     * de chaque VieMarine
     */
    public abstract void agir();

}