public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    public Baleine(int size, Terrain t, Simulation s, int lig, int col) {
        super(size, t, s, lig, col);
        this.id = ++cptBal;
    }

    public Baleine(Terrain t, Simulation s) {
        super(5, t, s);
        this.id = ++cptBal;
    }


    public void donnerNaissance(Terrain t, Simulation s) {
        Baleine bebe = new Baleine(t, s);
        s.addAgent(bebe);
    }

    public static int getTotalChaque() {
        return cptBal;
    }


    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }
}
