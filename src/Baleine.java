//TRAN ET LE
import java.util.ArrayList;

/**
 * Représente une baleine dans la simulation.
 * Elle peut se déplacer, manger et se reproduire.
 */
public class Baleine extends MammifereMarine {

    /** Nombre total de baleines. */
    private static int cptBal = 0;

    /** Identifiant unique. */
    private int id;

    /** Indique si la baleine a déjà donné naissance. */
    private boolean avaitNaissance = false;

    /**
     * Constructeur avec position.
     */
    public Baleine(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptBal;
    }

    /**
     * Constructeur avec position aléatoire.
     */
    public Baleine(Terrain t, Simulation s) {
        super(20, t, s);
        this.id = ++cptBal;
    }

    /**
     * Retourne l'identifiant de la baleine.
     * @return identifiant
     */
    public int getId() {
        return this.id;
    }

    /**
     * Permet à la baleine de donner naissance.
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
                    int size = (int) (Math.random() * 5 + 1);
                    Baleine bebe = new Baleine(size, terrain, simulation, newL, newC);
                    simulation.addAgent(bebe);

                    System.out.println("Un Baleine a naissance près de la mère en (" + newL + ", " + newC + ")");
                    this.avaitNaissance = true;
                    return;
                }
            }
        }
    }

    /**
     * Retourne le nombre total de baleines.
     * @return total
     */
    public static int getTotalChaque() {
        return cptBal;
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }

    /**
     * Définit les actions de la baleine.
     */
    public void agir() {
        for (int i = 0; i < 3; i++) {

            deplacementUnitaire();

            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);

            for (Agent a : ici) {

                if (a != this && (a instanceof Pieuvre || a instanceof Dauphin)) {
                    simulation.removeAgent(a);
                    if (a instanceof Dauphin) {
                        System.out
                                .println(
                                        "Le Baleine " + this.id + " a manger le " + ((Dauphin) a).getId() + " Dauphin");
                    } else {
                        System.out
                                .println(
                                        "Le Baleine " + this.id + " a manger le " + ((Pieuvre) a).getId() + " Pieuvre");
                    }
                    return;
                }

                if (a != this && a instanceof Baleine && Math.random() < 0.4) {
                    donnerNaissance();
                    return;
                }
            }

        }
    }
}