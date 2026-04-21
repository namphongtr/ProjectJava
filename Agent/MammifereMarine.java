package Project.Agent;
public abstract class MammifereMarine extends VieMarine{
    private int size;

    public MammifereMarine(int size, Terrain t, int lig, int col) {
        super(t, lig, col);
        this.size = (int)(Math.random()*size + 1);
    }

    public MammifereMarine(int size, Terrain t) {
        super(t);
        this.size = (int)(Math.random()*size + 1);
    }

    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

}
