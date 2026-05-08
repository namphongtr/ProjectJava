//TRAN ET LE

/**
 * Représente un déchet dans la simulation.
 */
public class Dechet extends Ressource {

    /**
     * Constructeur.
     * @param quantite quantité initiale
     */
    public Dechet(int quantite) {
        super("Dechet", quantite);
    }

    /**
     * Constructeur avec la quantite aleatoire.
     */
    public Dechet() {
        this((int) (Math.random() * 20));
    }

    // Pas besoin de seDevelopper pour les déchets, ils ne se reproduisent pas
}