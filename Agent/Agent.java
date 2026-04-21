package Project.Agent;

public abstract class Agent {
    protected int ligne;
    protected int colonne;
    protected Terrain terrain;

    public Agent(Terrain t, int lig, int col) {
        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
    }

    public Agent(Terrain t) {
        int lig, col;

        do {
            lig = (int)(Math.random() * t.nbLignes) + 1;
            col = (int)(Math.random() * t.nbColonnes) + 1;
        } while (!t.caseEstVide(lig, col));

        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
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