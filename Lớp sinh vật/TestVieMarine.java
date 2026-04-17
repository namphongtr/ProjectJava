public class TestVieMarine {
    public static void main(String[] args) {
        System.out.println("Total creature sous la mer " + VieMarine.getTotalCreature());

        Baleine b1 = new Baleine("Marthar");
        Baleine b2 = new Baleine("Marth");
        Dauphin d1 = new Dauphin("Steve");
        Dauphin d2 = new Dauphin("Ste");
        Pieuvre p1 = new Pieuvre("Lara");

        System.out.println("Total creature sous la mer " + VieMarine.getTotalCreature());

        Couleur couleurs = new Couleur();
        couleurs.addColor("red");
        couleurs.addColor("pink");


        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println("Il y a " + Baleine.getTotalChaque() + " Baleine");
        

        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println("Il y a " + Dauphin.getTotalChaque() + " Dauphin");

        System.out.println(p1.toString());
        System.out.println("Il y a " + Pieuvre.getTotalChaque() + " Pieuvre");

        p1.changerCouleur(couleurs);
        System.out.println(p1.toString());

    }
    
}
