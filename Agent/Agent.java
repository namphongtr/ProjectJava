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
        this(
        t,
        (int)(Math.random()*t.nbLignes) + 1,
        (int)(Math.random()*t.nbColonnes) + 1
    );
    }

    public boolean seDeplacer(int lig, int col) {
        if (terrain.sontValides(lig, col) && terrain.caseEstVide(lig, col)) {
            this.ligne = lig;
            this.colonne = col;
            return true;
        }
        return false;
    }
}