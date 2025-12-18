import java.util.Scanner;
import java.util.Random;

class Jeu{
    /** Attributs */
    private PaquetCartes main;
    private PaquetCartes pioche;
    private String nomFichier;
    private int nombreCarte;

    /**
     * Constructeur a partir d'un nom de fichier et le nombre de carte pour la main du joueur
     * @param nf nom du fichier pour la pioche
     * @param nb nombre de cartes dans la main du joueur
     */
    public Jeu(String nf, int nb){
        this.nomFichier=nf;
        this.nombreCarte=nb;
        //on cree donc un paquets de carte a partir du nom du fichier et une main vide pour le joueur
        this.pioche= new PaquetCartes(nf);
        this.main= new PaquetCartes();
        // On pioche le nombre de carte necessaires pour le joueur
        for(int i=0;i<nb;i++){
            this.piocher();
        }
    }

    /**
     * Methode qui permet de piocher une carte dans la pioche et de l'ajouter dans la main du joueur
     */
    public void piocher(){
        Carte c=pioche.piocherHasard();
        if (c!=null){
            main.ajouterCarteFin(c);
        }
    }
    
    /**
     * Une manche de jeu
     */
    public void jouerUneManche(){
        Scanner sc=new Scanner(System.in);
        Random rm=new Random();

        Carte cartePioche=pioche.piocherHasard();
        if (cartePioche==null){
            return;
        }
        cartePioche.setVisible();
        System.out.println("Voici la carte pioche par le joueur : " + cartePioche);
        Carac[] caracs = cartePioche.getCaracs();
        int indiceCarac = rm.nextInt(caracs.length);
        String carachasard = caracs[indiceCarac].getNomCarac();
        System.out.println("caracteristique testee :" + carachasard);
        System.out.println("Voici la main du joueur");
        for (int i=0; i<main.getNbCartes(); i++) {
            System.out.println(i + ". " + main.getCarte(i));
        }
        System.out.print("Choisissez la carte la plus proche :  ");
        int choix= sc.nextInt();
        int bc= main.trouverCarteProche(cartePioche, carachasard);
        Carte carteJoue= main.getCarte(choix);
        if (choix==bc){
            System.out.println("Vous avez choisit la meilleure carte.");
            main.retirerCarte(choix);
        } else{
            System.out.println("Dommage, il y'avais une carte plus proche.");
            Carte mr=main.getCarte(bc);
            mr.setVisible();
            System.out.println("Voici la meilleure carte : " + mr);
            main.retirerCarte(choix);
            main.retirerCarte(bc);
            piocher();
            piocher();
        }
    }
        
        /**
         * Methode qui permet de jouer une partie complete
         */
    public void jouer(){
        while (main.getNbCartes() > 0 && pioche.getNbCartes() > 0) {
            jouerUneManche();
        }
        if (main.getNbCartes() == 0) {
            System.out.println("Victoire, vous avez joue toute vos cartes.");
        } else {
            System.out.println("Defaite, la pioche est vide.");
        }
    }
    


}
