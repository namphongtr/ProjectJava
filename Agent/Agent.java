
public abstract class Agent {
    protected int ligne;
    protected int colonne;
    protected Terrain terrain;
    private Simulation simulation;

    public Agent(Terrain t, Simulation s, int lig, int col) {
        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
        this.simulation = s;
    }

    public Agent(Terrain t, Simulation s) {
        int lig, col;

        do {
            lig = (int)(Math.random() * t.nbLignes) + 1;
            col = (int)(Math.random() * t.nbColonnes) + 1;
        } while (!t.caseEstVide(lig, col));

        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
        this.simulation = s;
    }

    public boolean seDeplacer(int lig, int col) {
        if (!terrain.sontValides(lig, col)) {
            return false;
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
}