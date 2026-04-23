/* Class Calmar extends de la class VieMarine pour determiner une Calmar a combien de Tentacules*/
public abstract class Calmar extends VieMarine {
    private int nbTentacules;

    /* Construction */
    public Calmar(int nbTentacules, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.nbTentacules = nbTentacules;
    }

    /* Construction de placer les Calmar en coordonner aleatoirement */
    public Calmar(int nbTentacules, Terrain t, Simulation s) {
        super(t, s);
        this.nbTentacules = nbTentacules;
    }

    /*
     * Construction de placer les Calmar en coordonner aleatoirement et avec le
     * nombre de Tentacules aleatoirement
     */
    public Calmar(Terrain t, Simulation s) {
        int nb = (int) (Math.random() * 3 + 8);
        this(nb, t, s);
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " a " + this.nbTentacules + " tentacules";
    }
}
