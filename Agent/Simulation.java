
import java.util.ArrayList;

public class Simulation {
    private Terrain terrain;
    private ArrayList<Agent> agents;
    private int nbEtapes;

    public Simulation(int nbAgents, int nbEtapes) {
        this.terrain = new Terrain(10, 10);
        this.agents = new ArrayList<>();
        this.nbEtapes = nbEtapes;

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

    public void addAgent(Agent a) {
        agents.add(a);
    }
}
