//TRAN ET LE
public class Dechet extends Ressource {

    /* Constructeur */
    public Dechet(int quantite) {
        super("Dechet", quantite);
    }

    public Dechet() {
        this((int) (Math.random() * 20));
    }

    // Pas besoin de seDevelopper pour les déchets, ils ne se reproduisent pas
}