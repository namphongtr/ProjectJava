
//TRAN ET LE
/* Class Dauphin extends MammifereMarine qui determiner combien de Dauphin dans le Terrain */
import java.util.ArrayList;

public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;
    private boolean avaitNaissance = false;

    /* Construction */
    public Dauphin(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptDau;
    }

    /*
     * Construction de placer les Dauphin en coordonner aleatoirement et de taille
     * aleatoirement
     */
    public Dauphin(Terrain t, Simulation s) {
        super(5, t, s);
        this.id = ++cptDau;
    }

    public int getId() {
        return this.id;
    }

    /* Methode de donner naissance dans la cellule proche de sa mere */
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

    /* Methode de prend totale de Dauphin dans le Terrain */
    public static int getTotalChaque() {
        return cptDau;
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }

    /*
     * Methode de determiner le Dauphin de Nager aleatoire, Manger ou donner
     * naissance
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
