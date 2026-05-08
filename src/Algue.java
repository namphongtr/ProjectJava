//TRAN ET LE

/**
 * Représente une algue.
 * Les algues peuvent se développer.
 */
public class Algue extends Ressource {
    
    /**
     * Constructeur.
     * @param quantite quantité initiale
     */
    public Algue(int quantite) {
        super("Algue", quantite);
    }

    /**
     * Constructeur avec quantite aléatoire.
     */
    public Algue() {
        this((int) (Math.random() * 20));
    }

    /**
     * Développe l'algue.
     */
    public void seDevelopper() {
        int qteActuelle = this.getQuantite();
        // Limite la quantité d'algues à 50 pour éviter une croissance infinie
        if (qteActuelle < 50) {
            this.setQuantite(qteActuelle + 2);
        }
    }
}