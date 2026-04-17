import java.util.ArrayList;
/*La class couleur pour un list de couleur pour le Pieuvre de changer */
public class Couleur {
    private static ArrayList<String> couleurs = new ArrayList<>();

    static {
        couleurs.add("rouge");
        couleurs.add("bleu");
        couleurs.add("vert");
        couleurs.add("grey");
    }  //Les couleurs default

    public void addColor(String coul) {
        if(!couleurs.contains(coul)) {
            couleurs.add(coul);
            System.out.println("Ajouter le couleur " + coul);
        } else {
            System.out.println(coul + " est deja exister");
        }
    } //Ajouter les couleurs

    public int getSize() {
        return couleurs.size();
    }

    public String getCoul(int num) {
        return couleurs.get(num);
    }


}
