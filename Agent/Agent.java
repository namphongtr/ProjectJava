
public abstract class Agent {
    protected int ligne;
    protected int colonne;
    protected Terrain terrain;
    protected Simulation simulation;
    

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

    //Une cellue chaque fois
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


    public void deplacementAleatoire() {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int i = (int)(Math.random() * 4);

        int newLig = ligne + directions[i][0];
        int newCol = colonne + directions[i][1];

        seDeplacer(newLig, newCol);
    }

    protected void deplacementUnitaire() {
        deplacementAleatoire(); // hoặc move 1 case hợp lệ
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}