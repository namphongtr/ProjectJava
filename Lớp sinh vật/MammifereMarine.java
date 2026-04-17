public abstract class MammifereMarine extends VieMarine{
    private int size;

    public MammifereMarine(int size) {
        super();
        this.size = (int)(Math.random()*size + 1);
    }

    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

}
