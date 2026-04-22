import java.util.ArrayList;

public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;

    public Dauphin(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptDau;
    }

    public Dauphin(Terrain t, Simulation s) {
        super(5, t, s);
        this.id = ++cptDau;
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
                int size = (int) (Math.random() * 3 + 1);
                Dauphin bebe = new Dauphin(size, terrain, simulation, newL, newC);
                simulation.addAgent(bebe);

                System.out.println("Naissance près de la mère !");
                return;
            }
        }
    }

    public static int getTotalChaque() {
        return cptDau;
    }

    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }

    // Nager aleatoire, Manger ou donner naissance
    public void agir() {
        int steps = 1 + (int) (Math.random() * 3);
        for (int i = 0; i < steps; i++) {

            deplacementUnitaire();

            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);

            for (Agent a : ici) {

                if (a != this && a instanceof Pieuvre) {
                    simulation.removeAgent(a);
                    return;
                }

                if (a instanceof Dauphin && Math.random() < 0.6) {
                    donnerNaissance();
                    return;
                }
            }

        }
    }
}
