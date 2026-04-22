import java.util.ArrayList;

public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    public Baleine(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptBal;
    }

    public Baleine(Terrain t, Simulation s) {
        super(20, t, s);
        this.id = ++cptBal;
    }

    // Donner naissance dans la cellule proche de sa mere
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

                System.out.println("Naissance près de la mère !");
                return;
            }
        }
    }

    public static int getTotalChaque() {
        return cptBal;
    }

    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }

    // Nager aleatoire, Manger ou donner naissance
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

                        if (Math.random() < 0.6) {
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
