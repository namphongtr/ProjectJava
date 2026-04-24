public class TestSimulation {
    public static void main(String[] args) {
        Simulation sim = Simulation.getInstance(5,5, 6, 2, 10);
        sim.run();
    }
}
