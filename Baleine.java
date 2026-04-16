public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    public Baleine(String nom, int size) {
        super(nom,size);
        this.id = cptBal;
        cptBal++;
    }

    public Baleine(String nom) {
        this(nom,30);
    }

    public void communiquer() {
        System.out.println(this.getNom() + "communiquer par Sonar");
    }

    public Baleine donnerNaissance(String nom) {
        return new Baleine(nom, 5);
    }

    public int getTotalChaque() {
        return cptBal;
    }

    public String toString() {
        return super.toString() + " est le " + this.id + " Baleine";
    }
}
