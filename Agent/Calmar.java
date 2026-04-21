package Project.Agent;
public abstract class Calmar extends VieMarine{
    private int nbTentacules;


    public Calmar(int nbTentacules, Terrain t, int lig, int col) {
        super(t, lig, col);
        this.nbTentacules = nbTentacules;
    }

    public Calmar(int nbTentacules, Terrain t) {
        super(t);
        this.nbTentacules = nbTentacules;
    }

    public Calmar(Terrain t) {
        int nb = (int)(Math.random()*3+8);
        this(nb, t);
    }
    


    public String toString() {
        return super.toString() + " a " + this.nbTentacules + " tentacules";
    }
}
