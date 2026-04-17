public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;

    public Dauphin(int size) {
        super(size);
        this.id = ++cptDau;
    }
    
    public void donnerNaissance() {
        new Dauphin(5);
    }

    public static int getTotalChaque() {
        return cptDau;
    }

    public String toString() {
        return super.toString() + " et est le " + this.id + " Dauphin";
    }
}
