//TRAN ET LE

/**
 * Classe abstraite représentant un calmar.
 */
public abstract class Calmar extends VieMarine {
    /** Nombre de tentacules. */
    private int nbTentacules;

    /**
     * Constructeur avec position.
     */
    public Calmar(int nbTentacules, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.nbTentacules = nbTentacules;
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public Calmar(int nbTentacules, Terrain t, Simulation s) {
        super(t, s);
        this.nbTentacules = nbTentacules;
    }

    /**
     * Constructeur de copie.
     */
    public Calmar(Calmar c) {
        super(c);
        this.nbTentacules = c.nbTentacules;
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public Calmar(Terrain t, Simulation s) {
        this((int) (Math.random() * 3 + 8), t, s);
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " a " + this.nbTentacules + " tentacules";
    }
}
