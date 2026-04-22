public class Pieuvre extends Calmar implements CouleurChangeable{
    private String couleur;
    private static int cptPieu = 0;
    private int id;


    public Pieuvre(int nbTentacules, String couleur, Terrain t, Simulation s, int lig, int col) {
        super(nbTentacules, t, s, lig, col);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }


    public Pieuvre(String couleur, Terrain t, Simulation s) {
        super(t, s);
        this.couleur = couleur;
        this.id = ++cptPieu;
    } 
    
    public Pieuvre(Terrain t, Simulation s) {
        this("grey", t, s);
    }

    public String choisirCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int)(Math.random()*size);
        return couleurs.getCoul(randNum);
    }

    public void changerCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int)(Math.random()*size);
        this.couleur = couleurs.getCoul(randNum);
        System.out.println("Le pieuvre " + this.id + " a change leur couleur a " + this.couleur);
    }

    public static int getTotalChaque() {
        return cptPieu;
    }

    public String toString() {
        return super.toString() + " couleur : " + this.couleur + " et est le " + this.id + " Pieuvre";
    }

    public void donnerNaissance(Terrain t, Simulation s) {
        Pieuvre bebe = new Pieuvre(t, s);
        s.addAgent(bebe);
    };
}
