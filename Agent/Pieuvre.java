import java.util.ArrayList;

public class Pieuvre extends Calmar implements CouleurChangeable {
    private String couleur;
    private static int cptPieu = 0;
    private int id;

    public Pieuvre(int nbTentacules, String couleur, Terrain t, Simulation s, int lig, int col) {
        super(nbTentacules, t, s, lig, col);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    public Pieuvre(String couleur, Terrain t, Simulation s) {
        super(t, s);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    public Pieuvre(Terrain t, Simulation s) {
        this("grey", t, s);
    }

    public String choisirCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int) (Math.random() * size);
        return couleurs.getCoul(randNum);
    }

    public void changerCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int) (Math.random() * size);
        this.couleur = couleurs.getCoul(randNum);
        System.out.println("Le pieuvre " + this.id + " a change leur couleur a " + this.couleur);
    }

    public static int getTotalChaque() {
        return cptPieu;
    }

    public String toString() {
        return super.toString() + " couleur : " + this.couleur + " et est le " + this.id + " Pieuvre";
    }

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

                System.out.println("Naissance près de la mère !");
                return;
            }
        }
    }

    public void agir() {

        for (int i = 0; i < 2; i++) {

            deplacementUnitaire();

            ArrayList<Agent> ici = simulation.getAgentsSameCell(ligne, colonne);

            int nbPieuvre = 0;

            for (Agent a : ici) {
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

                for (Agent a : ici) {
                    if (a instanceof Pieuvre && a != this) {

                        if (Math.random() < 0.6) {
                            donnerNaissance();
                        }

                        return;
                    }
                }
            }
        }
    }
}
