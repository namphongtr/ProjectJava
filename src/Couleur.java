
//TRAN ET LE
import java.util.ArrayList;

/**
 * Gère la liste des couleurs disponibles.
 */
public class Couleur {

    /** Liste des couleurs. */
    private static ArrayList<String> couleurs = new ArrayList<>();

    /**
     * Ajoute une nouvelle couleur.
     * 
     * @param coul couleur à ajouter
     */
    static {
        couleurs.add("red");
        couleurs.add("blue");
        couleurs.add("green");
        couleurs.add("grey");
    }

    /**
     * Ajoute une nouvelle couleur.
     * 
     * @param coul couleur à ajouter
     */
    public void addColor(String coul) {
        if (!couleurs.contains(coul)) {
            couleurs.add(coul);
            System.out.println("Ajouter le couleur " + coul);
        } else {
            System.out.println("Le couleur " + coul + " est deja exister");
        }
    }

    /**
     * Retourne le nombre de couleurs.
     * 
     * @return taille
     */
    public int getSize() {
        return couleurs.size();
    }

    /**
     * Retourne une couleur selon son indice.
     * 
     * @param num indice
     * @return couleur
     */
    public String getCoul(int num) {
        return couleurs.get(num);
    }

}
