public class Baleine extends MammifereMarine {
    private static int cptBal = 0;
    private int id;

    public Baleine(int size) {
        super(size);
        this.id = ++cptBal;
    }


    public void donnerNaissance() {
        new Baleine(5);
    }

    public static int getTotalChaque() {
        return cptBal;
    }


    public String toString() {
        return super.toString() + " et est le " + this.id + " Baleine";
    }
}
