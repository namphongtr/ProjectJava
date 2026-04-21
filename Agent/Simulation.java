package Project.Agent;

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
        initRessources();
    }

    public void addAgent(Agent a) {
        agents.add(a);
    }
}
