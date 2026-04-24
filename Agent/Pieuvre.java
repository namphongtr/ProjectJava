
//TRAN ET LE
/* Class Pieuvre extends la class Calmar qui determiner le couleur, le total de Pieuvre dans le Terrain et s'il peut courir */
import java.util.ArrayList;

public class Pieuvre extends Calmar implements CouleurChangeable {
    private String couleur;
    private static int cptPieu = 0;
    private int id;
    private boolean camoufle = false;

    /* Construction */
    public Pieuvre(int nbTentacules, String couleur, Terrain t, Simulation s, int lig, int col) {
        super(nbTentacules, t, s, lig, col);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    /*
     * Construction de placer les Pieuvre en coordonner aleatoirement et de nombre
     * de Tentacules
     * aleatoirement
     */
    public Pieuvre(String couleur, Terrain t, Simulation s) {
        super(t, s);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    /*
     * Construction de placer les Pieuvre en coordonner aleatoirement et de nombre
     * de Tentacules
     * aleatoirement avec le couleur default "grey"
     */
    public Pieuvre(Terrain t, Simulation s) {
        this("grey", t, s);
    }

    // Constructeur de copie
    public Pieuvre(Pieuvre p) {
        super(p);
        this.couleur = p.couleur;
        this.id = ++cptPieu;
    }

    public int getId() {
        return this.id;
    }

    /*
     * Methode de choisir couleur aleatoirement dans l'ArrayList dans class Couleur
     */
    public String choisirCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int) (Math.random() * size);
        return couleurs.getCoul(randNum);
    }

    /*
     * Methode de changer couleur aleatoirement dans l'ArrayList dans class Couleur
     */
    public void changerCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int) (Math.random() * size);
        this.couleur = couleurs.getCoul(randNum);
        System.out.println("Le pieuvre " + this.id + " a change leur couleur a " + this.couleur);
        this.camoufle = true;
    }

    /* Methode de prend total de Pieuvre dans le Terrain */
    public static int getTotalChaque() {
        return cptPieu;
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " couleur : " + this.couleur + " et est le " + this.id + " Pieuvre";
    }

    /* Methode de donner naissance dans la cellule proche de sa mere */
    public void donnerNaissance() {

        int[][] directions = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        for (int[] d : directions) {
            int newL = ligne + d[0];
            int newC = colonne + d[1];

            if (terrain.sontValides(newL, newC)) {
                int size = (int) (Math.random() * 3 + 1);
                Pieuvre bebe = new Pieuvre(terrain, simulation);
                simulation.addAgent(bebe);

                System.out.println("Un Pieuvre a naissance près de la mère en (" + newL + ", " + newC + ")");
                return;
            }
        }
    }

    /*
     * Methode de determiner le Pieuvre de Nager aleatoire, Manger ou donner
     * naissance
     */
    public void agir() {
        if (camoufle) {
            camoufle = false;
            deplacementUnitaire();
            return;
        }

        int steps = 1 + (int) (Math.random() * 2);
        for (int i = 0; i < steps; i++) {
            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);
            ArrayList<Agent> voisins = simulation.getAgentsAround(ligne, colonne);
            int nbPieuvre = 1;
            for (Agent a : voisins) {
                if (a instanceof Pieuvre)
                    nbPieuvre++;
            }
            if (nbPieuvre > 1) {
                for (Agent a : ici) {
                    if (a != this && (a instanceof Dauphin || a instanceof Pieuvre)) {
                        simulation.removeAgent(a);
                        System.out.println(this + " attaque " + a);
                        return;
                    }
                }
            }
            if (nbPieuvre > 1) {
                for (Agent a : ici) {
                    if (a instanceof Pieuvre && a != this) {

                        if (Math.random() < 0.6) {
                            donnerNaissance();
                        }
                        return;
                    }
                }

            }
            deplacementUnitaire();
        }
    }
}
