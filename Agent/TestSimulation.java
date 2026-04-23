public class TestSimulation {
    public static void main(String[] args) {
        Terrain t = new Terrain(5, 5);
        Simulation s = new Simulation(t10);

        System.out.println("Agents initialement :");
        for (Agent a : s.getAgents()) {
            System.out.println(a);
        }

        System.out.println("\nDéplacement des agents...");
        for (Agent a : s.getAgents()) {
            a.deplacementUnitaire();
            System.out.println(a);
        }
    }
}
