
public abstract class MammifereMarine extends VieMarine{
    private int size;

    public MammifereMarine(int size, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.size = (int)(Math.random()*size + 1);
    }

    public MammifereMarine(int size, Terrain t, Simulation s) {
        super(t, s);
        this.size = (int)(Math.random()*size + 1);
    }

    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

}
