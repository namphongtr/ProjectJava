
//TRAN ET LE
import java.util.ArrayList;

public class Simulation {
    private static Simulation instance;
    private Terrain terrain;
    private ArrayList<Agent> agents;
    private int nbEtapes;
    private ArrayList<Agent> aSupprimer;
    private Couleur couleurs;

    private Simulation(int nbLig, int nbCol, int nbAgents, int nbRessources, int nbEtapes) {
        this.terrain = new Terrain(nbLig, nbCol);
        this.agents = new ArrayList<>();
        this.nbEtapes = nbEtapes;
        this.aSupprimer = new ArrayList<>();
        this.couleurs = new Couleur();

        initAgents(nbAgents);
        initRessources(nbRessources); // Pour ajouter les ressource
    }

    public static Simulation getInstance(int nbLig, int nbCol, int nbAgents, int nbRessources, int nbEtapes) {
        if (instance == null) {
            instance = new Simulation(nbLig, nbCol, nbAgents, nbRessources, nbEtapes);
        }
        return instance;
    }

    private void initAgents(int n) {
        for (int i = 0; i < n; i++) {
            int type = (int) (Math.random() * 3);
            if (type == 0) {
                agents.add(new Baleine(terrain, this));
            } else if (type == 1) {
                agents.add(new Dauphin(terrain, this));
            } else {
                agents.add(new Pieuvre(terrain, this));
            }
        }
    }

    /*
     * private void initRessources(int nbRessources) {
     * int placees = 0;
     * while (placees < nbRessources) {
     * int lig = (int) (Math.random() * terrain.nbLignes) + 1;
     * int col = (int) (Math.random() * terrain.nbColonnes) + 1;
     * 
     * if (terrain.caseEstVide(lig, col)) {
     * Ressource r;
     * if (Math.random() < 0.5) {
     * r = new Algue(10);
     * } else {
     * r = new Dechet(5);
     * }
     * terrain.setCase(lig, col, r);
     * placees++;
     * }
     * }
     * }
     */

    private void initRessources(int nbRessources) {
        for (int i = 0; i < nbRessources; i++) {
            int lig = (int) (Math.random() * terrain.nbLignes) + 1;
            int col = (int) (Math.random() * terrain.nbColonnes) + 1;
            int type = (int) (Math.random() * 2);
            if (type == 0) {
                terrain.setCase(lig, col, new Algue());
                System.out.println("Le ressource Algue est dans (" + lig + ", " + col + ")");
            } else if (type == 1) {
                terrain.setCase(lig, col, new Dechet());
                System.out.println("Le ressource Dechet est dans (" + lig + ", " + col + ")");
            }
        }
    }

    public ArrayList<Agent> getAgentsAround(int lig, int col) {

        ArrayList<Agent> voisins = new ArrayList<>();

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] d : directions) {

            int newLig = lig + d[0];
            int newCol = col + d[1];

            if (terrain.sontValides(newLig, newCol)) {

                for (Agent a : agents) {
                    if (a.getLigne() == newLig && a.getColonne() == newCol) {
                        voisins.add(a);
                    }
                }
            }
        }

        return voisins;
    }

    public ArrayList<Agent> getAgentsSameCell(int lig, int col) {

        ArrayList<Agent> res = new ArrayList<>();

        for (Agent a : agents) {
            if (a.getLigne() == lig && a.getColonne() == col) {
                res.add(a);
            }
        }

        return res;
    }

    public void addAgent(Agent a) {
        agents.add(a);
    }

    public void removeAgent(Agent a) {
        if (a instanceof Pieuvre) {
            if (Math.random() < 0.35) {
                System.out.println("Le Pieuvre " + ((Pieuvre)a).getId() + " a change couleur et a echaper");
                ((Pieuvre) a).changerCouleur(couleurs);
                return;
            }
        }
        if (!aSupprimer.contains(a)) {
            aSupprimer.add(a);
        }
    }

    public void step() {
        ArrayList<Agent> copie = new ArrayList<>(agents);
        for (Agent a : copie) {
            a.agir();
            if (a instanceof Pieuvre && Math.random() < 0.1) {
                ((Pieuvre) a).changerCouleur(couleurs);
            }
        }
        updateFinEtape();
    }

    public void run() {
        for (int i = 1; i <= nbEtapes; i++) {
            System.out.println("----- Étape " + i + " -----");
            terrain.afficher(5);
            System.out.println("Les actions des Agents :");
            step();
            afficherEtat();
        }
    }

    public void afficherEtat() {
        System.out.println("Nombre d'agents: " + agents.size());
        for (Agent a : agents) {
            System.out.println(a + " (" + a.getLigne() + "," + a.getColonne() + ")");
        }
    }

    public void updateFinEtape() {
        for (Agent a : aSupprimer) {
            if (agents.contains(a)) {
                agents.remove(a);
            }
        }

        aSupprimer.clear();
    }
}
