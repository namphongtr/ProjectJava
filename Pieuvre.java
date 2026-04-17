public class Pieuvre extends Calmar implements CouleurChangeable{
    private String couleur;
    private static int cptPieu = 0;
    private int id;


    public Pieuvre(String nom, int nbTentacules, String couleur) {
        super(nom, nbTentacules);
        this.couleur = couleur;
        this.id = cptPieu + 1;
        cptPieu++;
    }
    
    public Pieuvre(String nom) {
        super(nom);
        this.couleur = "grey";
        this.id = cptPieu;
        cptPieu++;
    }

    public void changerCouleur(Couleur couleurs) {
        int size = couleurs.getSize();
        int randNum = (int)(Math.random()*size);

        this.couleur = couleurs.getCoul(randNum);
    }

    public int getTotalChaque() {
        return cptPieu;
    }

    public String toString() {
        return super.toString() + " couleur : " + this.couleur + " et est le " + this.id + " Pieuvre";
    }
}
