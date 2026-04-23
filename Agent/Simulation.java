//TRAN ET LE
import java.util.ArrayList;

public class Simulation {
    private Terrain terrain;
    private ArrayList<Agent> agents;
    private int nbEtapes;
    private ArrayList<Agent> aSupprimer;
    private Couleur couleurs;

    public Simulation(int nbAgents, int nbEtapes) {
        this.terrain = new Terrain(10, 10);
        this.agents = new ArrayList<>();
        this.nbEtapes = nbEtapes;
        this.aSupprimer = new ArrayList<>();
        this.couleurs = new Couleur();

        initAgents(nbAgents);
        initRessources(20); //Pour ajouter les ressource
    }

    private void initAgents(int n) {
        for (int i = 0; i < n; i++) {

            int type = (int) (Math.random() * 3);

            if (type == 0) {
                agents.add(new Baleine(terrain, this));
            } else if (type == 1) {
                agents.add(new Dauphin(terrain, this));
            } else {
                agents.add(new Pieuvre(terrain, this));
            }
        }
    }

    private void initRessources(int nbRessources) {
        int placees = 0;
        while (placees < nbRessources) {
            int lig = (int) (Math.random() * terrain.nbLignes) + 1;
            int col = (int) (Math.random() * terrain.nbColonnes) + 1;

            if (terrain.caseEstVide(lig, col)) {
                Ressource r;
                if (Math.random() < 0.5) {
                    r = new Algue(10); 
                } else {
                    r = new Dechet(5);
                }
                terrain.setCase(lig, col, r);
                placees++;
            }
        }
    }

    public ArrayList<Agent> getAgentsAround(int lig, int col) {

        ArrayList<Agent> voisins = new ArrayList<>();

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] d : directions) {

            int newLig = lig + d[0];
            int newCol = col + d[1];

            if (terrain.sontValides(newLig, newCol)) {

                for (Agent a : agents) {
                    if (a.getLigne() == newLig && a.getColonne() == newCol) {
                        voisins.add(a);
                    }
                }
            }
        }

        return voisins;
    }

    public ArrayList<Agent> getAgentsSameCell(int lig, int col) {

        ArrayList<Agent> res = new ArrayList<>();

        for (Agent a : agents) {
            if (a.getLigne() == lig && a.getColonne() == col) {
                res.add(a);
            }
        }

        return res;
    }

    public void addAgent(Agent a) {
        agents.add(a);
    }

    public void removeAgent(Agent a) {
        if (a instanceof Pieuvre) {
            if (Math.random() < 0.35) {
                System.out.println(a + "a change couleur et a echaper");
                ((Pieuvre) a).changerCouleur(couleurs);
                return;
            }
        }
        if (!aSupprimer.contains(a)) {
            aSupprimer.add(a);
        }
    }

    /**
 * Realiser une étape de la simulation: chaque agent agit, les ressources se mettent à jour, et les agents morts sont retirés.
 * Affiche les statistiques après chaque étape.
 */
public void uneEtape() {
    System.out.println("\n=== Bước mô phỏng mới ===");

    // Chaque Agent agir
    // Utiliser le copie de la liste pour éviter les problèmes de modification pendant l'itération
    ArrayList<Agent> copyAgents = new ArrayList<>(this.agents);
    for (Agent a : copyAgents) {
        if (a instanceof VieMarine) {
            ((VieMarine) a).agir();
        }
    }

    // Mise à jour des ressources (ex: les algues se développent)
    for (Ressource r : terrain.lesRessources()) {
        if (r instanceof Algue) {
            ((Algue) r).seDevelopper(); 
        }
    }

    // Mise à jour apres chaque étape
    updateFinEtape();

    // Affichage des statistiques après chaque étape
    System.out.println("Final:");
    System.out.println("- Agents restants: " + agents.size());
    System.out.println("- Ressources restantes: " + terrain.compterRessources());
    
}

    public void updateFinEtape() {
        for (Agent a : aSupprimer) {
            if (agents.contains(a)) {
                agents.remove(a);
            }
        }

        aSupprimer.clear();
    }
}
