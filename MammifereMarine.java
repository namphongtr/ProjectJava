public abstract class MammifereMarine extends VieMarine{
    private int size;

    public MammifereMarine(String nom, int size) {
        super(nom);
        this.size = (int)Math.random()*size + 1;
    }

    public String respirer() {
        return this.getNom() + " a fait surface sur le rivage pour respirer";
    }

    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

    public abstract void communiquer();
}
