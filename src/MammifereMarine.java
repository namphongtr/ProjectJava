//TRAN ET LE
/**
 * Classe abstraite représentant un mammifère marin.
 */
public abstract class MammifereMarine extends VieMarine {

    /** Taille du mammifère. */
    private int size;

    /**
     * Constructeur avec position.
     */
    public MammifereMarine(int size, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.size = (int) (Math.random() * size + 1);
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public MammifereMarine(int size, Terrain t, Simulation s) {
        super(t, s);
        this.size = (int) (Math.random() * size + 1);
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

}
