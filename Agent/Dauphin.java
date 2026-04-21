package Project.Agent;
public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;

    public Dauphin(int size, Terrain t, int lig, int col) {
        super(size, t, lig ,col);
        this.id = ++cptDau;
    }

    public Dauphin(int size, Terrain t) {
        super(size, t);
        this.id = ++cptDau;
    }
    
    public void donnerNaissance(Terrain t) {
        new Dauphin(5, t);
    }

    public static int getTotalChaque() {
        return cptDau;
    }

    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }
}
