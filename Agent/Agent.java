//TRAN ET LE
/* La class Agent pour determiner les coordonner des Agents dans le Terrain */
public abstract class Agent {
    protected int ligne;
    protected int colonne;
    protected Terrain terrain;
    protected Simulation simulation;

    /* Construction */
    public Agent(Terrain t, Simulation s, int lig, int col) {
        this.terrain = t;
        this.ligne = lig;
        this.colonne = col;
        this.simulation = s;
    }

    /* Construction de placer les Agent en coordonner aleatoirement */
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

    /* Construction de copie */
    public Agent(Agent a) {
        this.terrain = a.terrain;
        this.ligne = a.ligne;
        this.colonne = a.colonne;
        this.simulation = a.simulation;
    }

    /* Methode de deplacement une cellule */
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

    /* Methode de deplacement aleatoirement */
    public void deplacementAleatoire() {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int i = (int) (Math.random() * 4);

        int newLig = ligne + directions[i][0];
        int newCol = colonne + directions[i][1];

        seDeplacer(newLig, newCol);
    }

    /* Methode pour calculer la distance entre l'agent et une case */
    public double distance(int lig, int col) {
        double dLig = this.ligne - lig;
        double dCol = this.colonne - col;
        return Math.sqrt((dLig * dLig) + (dCol * dCol));
    }

    /* Methode de deplacement aleatoirement une cellule chaque fois */
    protected void deplacementUnitaire() {
        deplacementAleatoire();
    }

    /* Prend le coordonner y */
    public int getLigne() {
        return ligne;
    }

    /* Prend le coordonner x */
    public int getColonne() {
        return colonne;
    }

    public abstract void agir();
}