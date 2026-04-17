public class Pieuvre extends Calmar implements CouleurChangeable{
    private String couleur;
    private static int cptPieu = 0;
    private int id;


    public Pieuvre(int nbTentacules, String couleur) {
        super(nbTentacules);
        this.couleur = couleur;
        this.id = ++cptPieu;
    }

    public Pieuvre(String couleur) {
        super();
        this.couleur = couleur;
        this.id = ++cptPieu;
    } 
    
    public Pieuvre() {
        this("grey");
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

    public void donnerNaissance() {
        new Pieuvre();
    };
}
