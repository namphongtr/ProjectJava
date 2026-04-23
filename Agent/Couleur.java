import java.util.ArrayList;
/*La class couleur pour un list de couleur pour le Pieuvre de changer */
public class Couleur {
    private static ArrayList<String> couleurs = new ArrayList<>();

    /* Ajouter les couleurs default */
    static {
        couleurs.add("red");
        couleurs.add("blue");
        couleurs.add("green");
        couleurs.add("grey");
    }  
    
    /* Methode pour ajouter les couleurs dans ArrayList */
    public void addColor(String coul) {
        if(!couleurs.contains(coul)) {
            couleurs.add(coul);
            System.out.println("Ajouter le couleur " + coul);
        } else {
            System.out.println("Le couleur " + coul + " est deja exister");
        }
    }

    /* Methode pour prend la taille de l'ArrayList */
    public int getSize() {
        return couleurs.size();
    }

    /* Methode de prend le couleur de l'index num */
    public String getCoul(int num) {
        return couleurs.get(num);
    }


}
