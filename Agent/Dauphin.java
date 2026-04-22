public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;

    public Dauphin(int size, Terrain t, Simulation s,int lig, int col) {
        super(size, t, s, lig ,col);
        this.id = ++cptDau;
    }

    public Dauphin(Terrain t, Simulation s) {
        super(4,  t, s);
        this.id = ++cptDau;
    }
    
    public void donnerNaissance(Terrain t, Simulation s) {
        Dauphin bebe = new Dauphin(t, s);
        s.addAgent(bebe);
    }

    public static int getTotalChaque() {
        return cptDau;
    }

    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }
}
