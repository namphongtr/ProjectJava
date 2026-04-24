//TRAN ET LE
/* Class MammifereMarine extend de la class VieMarine determiner la taille des MammifereMarine */
public abstract class MammifereMarine extends VieMarine {
    private int size;

    /* Construction */
    public MammifereMarine(int size, Terrain t, Simulation s, int lig, int col) {
        super(t, s, lig, col);
        this.size = (int) (Math.random() * size + 1);
    }

    /*
     * Construction de placer les Mammifere en coordonner aleatoirement et de taille
     * aleatoirement au dessus de taille donne
     */
    public MammifereMarine(int size, Terrain t, Simulation s) {
        super(t, s);
        this.size = (int) (Math.random() * size + 1);
    }

    /* Methode de l'affiche */
    public String toString() {
        return super.toString() + " est " + this.size + "m";
    }

}
