//TRAN ET LE
import java.util.ArrayList;


/**
 * Représente un dauphin.
 */
public class Dauphin extends MammifereMarine {

    /** Nombre total de dauphins. */
    private static int cptDau = 0;

    /** Identifiant unique. */
    private int id;

    /** Indique si le dauphin a déjà donné naissance. */
    private boolean avaitNaissance = false;

    /**
     * Constructeur avec position.
     */
    public Dauphin(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptDau;
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public Dauphin(Terrain t, Simulation s) {
        super(5, t, s);
        this.id = ++cptDau;
    }

    /**
     * Retourne l'identifiant du dauphin.
     * @return identifiant
     */
    public int getId() {
        return this.id;
    }

    /**
     * Permet au dauphin de se reproduire.
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
                    Dauphin bebe = new Dauphin(size, terrain, simulation, newL, newC);
                    simulation.addAgent(bebe);

                    System.out.println("Un Dauphin a naissance près de la mère en (" + newL + ", " + newC + ")");
                    this.avaitNaissance = true;
                    return;
                }
            }
        }
    }

    /**
     * Retourne le nombre total de dauphins.
     * @return total
     */
    public static int getTotalChaque() {
        return cptDau;
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }

    /**
     * Définit les actions du dauphin.
     */
    public void agir() {
        int steps = 1 + (int) (Math.random() * 3);
        for (int i = 0; i < steps; i++) {

            deplacementUnitaire();

            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);

            for (Agent a : ici) {

                if (a != this && a instanceof Pieuvre) {
                    simulation.removeAgent(a);
                    System.out.println("Le Dauphin " + this.id + " a manger le " + ((Pieuvre) a).getId() + " Pieuvre");
                    return;
                }

                if (a != this && a instanceof Dauphin && Math.random() < 0.4) {
                    donnerNaissance();
                    return;
                }
            }

        }
    }
}
