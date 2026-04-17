public class TestVieMarine {
    public static void main(String[] args) {
        System.out.println("Total creature sous la mer" + VieMarine.getTotalCreature());

        Baleine b1 = new Baleine("Marthar");
        Dauphin d1 = new Dauphin("Steve");
        Pieuvre p1 = new Pieuvre("Lara");

        System.out.println("Total creature sous la mer" + VieMarine.getTotalCreature());

        Couleur couleurs = new Couleur();
        couleurs.addColor("red");
        couleurs.addColor("pink");


        System.out.println(b1.toString());
        System.out.println(d1.toString());
        System.out.println(p1.toString());

        p1.changerCouleur(couleurs);
        System.out.println(p1.toString());

    }
    
}
