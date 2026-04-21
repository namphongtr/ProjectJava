package Project.Agent;
public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    public Baleine(int size, Terrain t, int lig, int col) {
        super(size, t, lig, col);
        this.id = ++cptBal;
    }

    public Baleine(int size, Terrain t) {
        super(size, t);
        this.id = ++cptBal;
    }


    public void donnerNaissance(Terrain t) {
        Baleine bebe = new Baleine(5, t);
        simulation.addAgent(bebe);
    }

    public static int getTotalChaque() {
        return cptBal;
    }


    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }
}
