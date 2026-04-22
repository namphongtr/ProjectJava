
import java.util.ArrayList;

public class Simulation {
    private Terrain terrain;
    private ArrayList<Agent> agents;
    private int nbEtapes;
    private ArrayList<Agent> aSupprimer;

    public Simulation(int nbAgents, int nbEtapes) {
        this.terrain = new Terrain(10, 10);
        this.agents = new ArrayList<>();
        this.nbEtapes = nbEtapes;
        this.aSupprimer = new ArrayList<>();

        initAgents(nbAgents);
        //initRessources(); Pour ajouter les ressource
    }

    private void initAgents(int n) {
        for (int i = 0; i < n; i++) {

            int type = (int)(Math.random() * 3);

            if (type == 0) {
                agents.add(new Baleine(terrain, this));
            } else if (type == 1) {
                agents.add(new Dauphin(terrain, this));
            } else {
                agents.add(new Pieuvre(terrain, this));
            }
        }
    }

    public ArrayList<Agent> getAgentsAround(int lig, int col) {
        ArrayList<Agent> voisins = new ArrayList<>();

        for (Agent a : agents) {
            int dLig = Math.abs(a.getLigne() - lig);
            int dCol = Math.abs(a.getColonne() - col);

            if (dLig + dCol == 1) {
                voisins.add(a);
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
        if (!aSupprimer.contains(a)) {
            aSupprimer.add(a);
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
