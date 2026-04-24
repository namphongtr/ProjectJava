//TRAN ET LE
/* Class Baleine extends MammifereMarine qui determiner combien de Baleine dans le Terrain */
import java.util.ArrayList;

public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    /* Construction */
    public Baleine(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptBal;
    }

    /*
     * Construction de placer les Baleine en coordonner aleatoirement et de taille
     * aleatoirement
     */
    public Baleine(Terrain t, Simulation s) {
        super(20, t, s);
        this.id = ++cptBal;
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
                int size = (int) (Math.random() * 5 + 1);
                Baleine bebe = new Baleine(size, terrain, simulation, newL, newC);
                simulation.addAgent(bebe);

                System.out.println("Un Baleine a naissance près de la mère en (" + newL + ", " + newC + ")");
                return;
            }
        }
    }

    /* Methode de prend totale de Baleine dans le Terrain */
    public static int getTotalChaque() {
        return cptBal;
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }

    /*
     * Methode de determiner le Baleine de Nager aleatoire, Manger ou donner
     * naissance
     */
    public void agir() {
        for (int i = 0; i < 3; i++) {
            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);

            int nbPieuvre = 0;

            for (Agent a : ici) {
                if (a instanceof Pieuvre) {
                    nbPieuvre++;
                }
            }

            if (nbPieuvre > 1) {

                for (Agent a : ici) {

                    if (a != this && (a instanceof Dauphin || a instanceof Pieuvre)) {

                        simulation.removeAgent(a);
                        System.out.println(this + " attaque " + a);
                        return;
                    }
                }

                for (Agent a : ici) {
                    if (a instanceof Pieuvre && a != this) {

                        if (Math.random() < 0.4) {
                            donnerNaissance();
                            System.out.println("Naissance de Pieuvre !");
                        }
                        return;
                    }
                }
            }
            deplacementUnitaire();
        }
    }
}