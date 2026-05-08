
//TRAN ET LE
import java.util.ArrayList;

/**
 * Classe principale gérant la simulation.
 */
public class Simulation {

    /** Instance unique de simulation. */
    private static Simulation instance;

    /** Terrain de simulation. */
    private Terrain terrain;

    /** Liste des agents. */
    private ArrayList<Agent> agents;

    /** Nombre d'étapes */
    private int nbEtapes;

    /** Liste d'attendre de supprimer */
    private ArrayList<Agent> aSupprimer;

    /** Liste des couleurs */
    private Couleur couleurs;

    /** Liste des ressources */
    private ArrayList<Ressource> ressources;

    /**
     * Constructeur privé (pattern Singleton).
     *
     * @param nbLig        nombre de lignes du terrain
     * @param nbCol        nombre de colonnes du terrain
     * @param nbAgents     nombre d’agents à initialiser
     * @param nbRessources nombre de ressources à placer
     * @param nbEtapes     nombre d’étapes de la simulation
     */
    private Simulation(int nbLig, int nbCol, int nbAgents, int nbRessources, int nbEtapes) {
        this.terrain = new Terrain(nbLig, nbCol);
        this.agents = new ArrayList<>();
        this.nbEtapes = nbEtapes;
        this.aSupprimer = new ArrayList<>();
        this.couleurs = new Couleur();
        this.ressources = new ArrayList<>();

        initAgents(nbAgents);
        initRessources(nbRessources); // Pour ajouter les ressource
    }

    /**
     * Retourne l’unique instance de Simulation (Singleton).
     *
     * @return instance de Simulation
     */
    public static Simulation getInstance(int nbLig, int nbCol, int nbAgents, int nbRessources, int nbEtapes) {
        if (instance == null) {
            instance = new Simulation(nbLig, nbCol, nbAgents, nbRessources, nbEtapes);
        }
        return instance;
    }

    /**
     * Initialise les agents de manière aléatoire
     * (Baleine, Dauphin ou Pieuvre).
     *
     * @param n nombre d’agents à créer
     */
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

    /**
     * Initialise les ressources (Algues ou Déchets) sur le terrain.
     *
     * @param nbRessources nombre de ressources à créer
     */
    private void initRessources(int nbRessources) {
        for (int i = 0; i < nbRessources; i++) {
            int lig = SimulationOutils.randomInt(terrain.nbLignes);
            int col = SimulationOutils.randomInt(terrain.nbColonnes);
            int type = SimulationOutils.randomInt(1);
            if (type == 0) {
                Algue algue = new Algue();
                algue.setPosition(lig, col); // Mettre à jour les coordonnées de l'algue
                terrain.setCase(lig, col, algue);
                ressources.add(algue); // Ajouter l'algue à la liste des ressources
                System.out.println("Le ressource Algue est dans (" + lig + ", " + col + ")");
            } else if (type == 1) {
                Dechet dechet = new Dechet();
                dechet.setPosition(lig, col); // Mettre à jour les coordonnées du déchet
                terrain.setCase(lig, col, dechet);
                ressources.add(dechet); // Ajouter le déchet à la liste des ressources
                System.out.println("Le ressource Dechet est dans (" + lig + ", " + col + ")");
            }
        }
    }

    /**
     * Retourne les agents situés autour d’une case (8 directions).
     *
     * @param lig ligne de la case
     * @param col colonne de la case
     * @return liste des agents voisins
     */
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

    /**
     * Retourne les agents présents sur la même case.
     *
     * @param lig ligne
     * @param col colonne
     * @return liste des agents sur la case
     */
    public ArrayList<Agent> getAgentsSameCell(int lig, int col) {

        ArrayList<Agent> res = new ArrayList<>();

        for (Agent a : agents) {
            if (a.getLigne() == lig && a.getColonne() == col) {
                res.add(a);
            }
        }

        return res;
    }

    /**
     * Ajoute un agent à la simulation.
     *
     * @param a agent à ajouter
     */
    public void addAgent(Agent a) {
        agents.add(a);
    }

    /**
     * Marque un agent pour suppression en fin d’étape.
     * Cas particulier : la Pieuvre peut parfois s’échapper.
     *
     * @param a agent à supprimer
     */
    public void removeAgent(Agent a) {
        if (a instanceof Pieuvre) {
            if (Math.random() < 0.35) {
                System.out.println("Le Pieuvre " + ((Pieuvre) a).getId() + " a change couleur et a echaper");
                ((Pieuvre) a).changerCouleur(couleurs);
                return;
            }
        }
        if (!aSupprimer.contains(a)) {
            aSupprimer.add(a);
        }
    }

    /**
     * Exécute une étape de simulation :
     * tous les agents agissent puis les suppressions sont appliquées.
     */
    public void step() {
        ArrayList<Agent> copie = new ArrayList<>(agents);
        for (Agent a : copie) {
            a.agir();
            if (a instanceof Pieuvre && Math.random() < 0.1) {
                ((Pieuvre) a).changerCouleur(couleurs);
            }
        }
        for (Ressource r : ressources) {
            if (r instanceof Algue) {
                ((Algue) r).seDevelopper();
            }
        }
        updateFinEtape();
    }

    /**
     * Lance la simulation complète.
     */
    public void run() {
        for (int i = 1; i <= nbEtapes; i++) {
            System.out.println("----- Étape " + i + " -----");
            terrain.afficher(5);
            System.out.println("Les actions des Agents :");
            step();
            afficherEtat();
        }
    }

    /**
     * Affiche l’état actuel de la simulation.
     */
    public void afficherEtat() {
        System.out.println("Nombre d'agents: " + agents.size());
        for (Agent a : agents) {
            System.out.println(a + " (" + a.getLigne() + "," + a.getColonne() + ")");
        }
    }

    /**
     * Supprime les agents marqués à la fin d’une étape.
     */
    public void updateFinEtape() {
        for (Agent a : aSupprimer) {
            if (agents.contains(a)) {
                agents.remove(a);
            }
        }

        aSupprimer.clear();
    }
}
