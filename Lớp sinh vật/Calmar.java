public abstract class Calmar extends VieMarine{
    private int nbTentacules;


    public Calmar(int nbTentacules) {
        super();
        this.nbTentacules = nbTentacules;
    }

    public Calmar() {
        int nb = (int)(Math.random()*3+8);
        this(nb);
    }
    


    public String toString() {
        return super.toString() + " a " + this.nbTentacules + " tentacules";
    }
}
