//TRAN ET LE

/**
   * Classe abstraite représentant une créature marine.
   * Hérite de Agent.
   */
public abstract class VieMarine extends Agent {

    /** Nombre total de créatures marines. */
    private static int cpt = 0;

    /** Identifiant unique. */
    private final int id;

    /**
     * Constructeur avec position.
     */
    public VieMarine(Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.id = ++cpt;
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public VieMarine(Terrain t, Simulation s) {
        super(t, s);
        this.id = ++cpt;
    }

    /**
     * Constructeur de copie.
     * @param v créature à copier
     */
    public VieMarine(VieMarine v) {
        super(v);
        this.id = v.id;
    }

    /**
     * Retourne le nombre total de créatures.
     * @return nombre total
     */
    public static int getTotalCreature() {
        return cpt;
    }

    /* Methode pour afficher */
    /**
     * Returns a string representation identifying this marine creature by its unique id.
     * @return a string describing the marine creature
     */
    public String toString() {
        return "Le " + this.id + " creature de la mer";
    }

    /**
     * Permet la reproduction.
     */
    public abstract void donnerNaissance();

    /**
     * Définit le comportement de la créature.
     */
    public abstract void agir();

}