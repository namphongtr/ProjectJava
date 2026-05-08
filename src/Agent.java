//TRAN ET LE
/**
 * Classe abstraite représentant un agent dans la simulation.
 * Un agent possède une position (ligne, colonne) et agit sur le terrain.
 */

/* La class Agent pour determiner les coordonner des Agents dans le Terrain */
public abstract class Agent {

    /** Ligne actuelle de l'agent. */
    protected int ligne;

    /** Colonne actuelle de l'agent. */
    protected int colonne;

    /** Terrain associé à l'agent. */
    protected Terrain terrain;

    /** Simulation associée à l'agent. */
    protected Simulation simulation;

    /**
     * Constructeur avec position définie.
     * 
     * @param t   terrain
     * @param s   simulation
     * @param lig ligne initiale
     * @param col colonne initiale
     */
    public Agent(Terrain t, Simulation s, int lig, int col) {
        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
        this.simulation = s;
    }

    /**
     * Constructeur avec position aléatoire.
     * 
     * @param t terrain
     * @param s simulation
     */
    public Agent(Terrain t, Simulation s) {
        int lig, col;

        do {
            lig = (int) (Math.random() * t.nbLignes) + 1;
            col = (int) (Math.random() * t.nbColonnes) + 1;
        } while (!t.caseEstVide(lig, col));

        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
        this.simulation = s;
    }

    /**
     * Constructeur de copie.
     * 
     * @param a agent à copier
     */
    public Agent(Agent a) {
        this.terrain = a.terrain;
        this.ligne = a.ligne;
        this.colonne = a.colonne;
        this.simulation = a.simulation;
    }

    /**
     * Déplace l'agent d'une case.
     * 
     * @param lig nouvelle ligne
     * @param col nouvelle colonne
     * @return true si le déplacement réussit
     */
    public boolean seDeplacer(int lig, int col) throws HorsTerrainException {
        if (!terrain.sontValides(lig, col)) {
            throw new HorsTerrainException("Deplacer hors Terrain !");

        }
        int dLig = Math.abs(lig - this.ligne);
        int dCol = Math.abs(col - this.colonne);
        if (dLig + dCol != 1) {
            return false;
        }
        this.ligne = lig;
        this.colonne = col;
        return true;
    }

    /**
     * Déplace l'agent aléatoirement.
     */
    public void deplacementAleatoire() {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int i = (int) (Math.random() * 4);

        int newLig = ligne + directions[i][0];
        int newCol = colonne + directions[i][1];

        try {
            seDeplacer(newLig, newCol);
        } catch (HorsTerrainException e) {
            System.out.println("Déplacement impossible: " + e.getMessage());
        }
    }

    /**
     * Calcule la distance entre l'agent et une case.
     * 
     * @param lig ligne cible
     * @param col colonne cible
     * @return distance euclidienne
     */
    public double distance(int lig, int col) {
        double dLig = this.ligne - lig;
        double dCol = this.colonne - col;
        return Math.sqrt((dLig * dLig) + (dCol * dCol));
    }

    /**
     * Effectue un déplacement unitaire.
     */
    protected void deplacementUnitaire() {
        deplacementAleatoire();
    }

    /**
     * Retourne la ligne actuelle.
     * 
     * @return ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Retourne la colonne actuelle.
     * 
     * @return colonne
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Définit le comportement de l'agent.
     */
    public abstract void agir();
}