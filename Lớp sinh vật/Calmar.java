public abstract class Calmar extends VieMarine{
    private int nbTentacules;


    public Calmar(String nom, int nbTentacules) {
        super(nom);
        this.nbTentacules = nbTentacules;
    }

    public Calmar(String nom) {
        int nb = (int)(Math.random()*3+8);
        this(nom,nb);
    }
    


    public String toString() {
        return super.getNom() + " a " + this.nbTentacules + " tentacules";
    }
}
