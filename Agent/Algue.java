//TRAN ET LE
public class Algue extends Ressource {
    /* Constructeur */
    public Algue(int quantite) {
        super("Algue", quantite);
    }

    public Algue() {
        this((int) (Math.random() * 20));
    }

    public void seDevelopper() {
        int qteActuelle = this.getQuantite();
        // Limite la quantité d'algues à 50 pour éviter une croissance infinie
        if (qteActuelle < 50) {
            this.setQuantite(qteActuelle + 2);
        }
    }
}