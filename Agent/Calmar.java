public abstract class Calmar extends VieMarine{
    private int nbTentacules;


    public Calmar(int nbTentacules, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.nbTentacules = nbTentacules;
    }

    public Calmar(int nbTentacules, Terrain t, Simulation s) {
        super(t, s);
        this.nbTentacules = nbTentacules;
    }

    public Calmar(Terrain t, Simulation s) {
        int nb = (int)(Math.random()*3+8);
        this(nb, t, s);
    }
    


    public String toString() {
        return super.toString() + " a " + this.nbTentacules + " tentacules";
    }
}
