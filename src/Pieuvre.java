//TRAN ET LE
import java.util.ArrayList;

/**
 * Représente une pieuvre.
 * Elle peut changer de couleur et se camoufler.
 */
public class Pieuvre extends Calmar implements CouleurChangeable {

    /** Couleur actuelle de la pieuvre. */
    private String couleur;

    /** Nombre total de pieuvres. */
    private static int cptPieu = 0;

    /** Identifiant unique. */
    private int id;

    /** État de camouflage. */
    private boolean camoufle = false;

    /** Indique si le pieuvre a déjà donné naissance. */
    private boolean avaitNaissance = false;

    /**
     * Constructeur avec position et couleur
     */
    public Pieuvre(int nbTentacules, String couleur, Terrain t, Simulation s, int lig, int col) {
        super(nbTentacules, t, s, lig, col);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    /**
     * Constructeur avec position et nombre de tentacules aléatoire.
     */
    public Pieuvre(String couleur, Terrain t, Simulation s) {
        super(t, s);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    /**
     * Constructeur avec position, nombre de tentacules aléatoire et le couleur "grey".
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

    /**
     * Retourne l'identifiant de la pieuvre.
     * @return identifiant
     */
    public int getId() {
        return this.id;
    }

    /**
     * Choisit une couleur aléatoire.
     * @param couleurs liste des couleurs
     * @return couleur choisie
     */
    public String choisirCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int) (Math.random() * size);
        return couleurs.getCoul(randNum);
    }

    /**
     * Change la couleur de la pieuvre.
     * @param couleurs liste des couleurs
     */
    public void changerCouleur(Couleur couleurs) {
        this.couleur = choisirCouleur(couleurs);
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

    /**
     * Permet à la pieuvre de donner naissance.
     */
    public void donnerNaissance() {
        if (!avaitNaissance) {
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
                    this.avaitNaissance = true;
                    return;
                }
            }
        }
    }

    /**
     * Définit les actions de la pieuvre.
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
                    if (a != this && (a instanceof Dauphin || a instanceof Baleine)) {
                        simulation.removeAgent(a);
                        if (a instanceof Dauphin) {
                            System.out
                                    .println("Le Pieuvre " + this.id + " attaque le Dauphin " + ((Dauphin) a).getId());
                        } else if (a instanceof Baleine) {
                            System.out
                                    .println("Le Pieuvre " + this.id + " attaque le Baleine " + ((Baleine) a).getId());
                        }
                        return;
                    }
                }
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
