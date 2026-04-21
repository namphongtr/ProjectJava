package Project.Agent;
public class Pieuvre extends Calmar implements CouleurChangeable{
    private String couleur;
    private static int cptPieu = 0;
    private int id;


    public Pieuvre(int nbTentacules, String couleur, Terrain t, int lig, int col) {
        super(nbTentacules, t, lig, col);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }



    public Pieuvre(String couleur, Terrain t) {
        super(t);
        this.couleur = couleur;
        this.id = ++cptPieu;
    } 
    
    public Pieuvre(Terrain t) {
        this("grey", t);
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

    public void donnerNaissance(Terrain t) {
        new Pieuvre(t);
    };
}
