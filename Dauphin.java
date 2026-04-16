public class Dauphin extends MammifereMarine {
    private static int cptDau = 0;
    private int id;

    public Dauphin(String nom, int size) {
        super(nom, size);
        this.id = cptDau;
        cptDau++;
    }
    
    public Dauphin(String nom) {
        this(nom, 5);
    }

    public void communiquer() {
        System.out.println(this.getNom() + "sifflement");
    }

    public Dauphin donnerNaissance(String nom) {
        return new Dauphin(nom, 5);
    }

    public int getTotalChaque() {
        return cptDau;
    }

    public String toString() {
        return super.toString() + " est le " + this.id + " Dauphin";
    }
}
