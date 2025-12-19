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
        
        // On choisit une carte au hasard dans la pioche
        Carte cartePioche=pioche.piocherHasard();
        if (cartePioche==null){
            return;
        }
        // On rends visible la carte
        cartePioche.setVisible();
        
        afficherTitre("CARTE ET CARAC");
        System.out.println(cartePioche.toString());
        // On choisit une caracteristique au hasard
        Carac[] caracs = cartePioche.getCaracs();
        int indiceCarac = rm.nextInt(caracs.length);
        String carachasard = caracs[indiceCarac].getNomCarac();
        System.out.println("caracteristique testee :" + carachasard);
        afficherTitre("");
        
        afficherTitre("MAIN DU JOUEUR");
        System.out.println(main.toString());
        afficherTitre("");
        afficherTitre("CHOIX");
        System.out.println("Quelle est la carte de votre main la plus proche ?");
        // On demande au joueur de faire un choix entre 0 et main-1
        int choix= sc.nextInt();
        afficherTitre("");
        // On trouve l'indice de la vrai meilleure carte
        int bc= main.trouverCarteProche(cartePioche, carachasard);
        Carte carteJoue= main.getCarte(choix);
        
        afficherTitre("CARTE JOUEE");
        System.out.println(carteJoue.toString());
        afficherTitre("");

        if (choix==bc){
            afficherTitre("REPONSE");
            System.out.println("bien joue, y avait pas mieux.");
            // On retire la carte de la main du joueur sans lui en rajouter
            main.retirerCarte(choix);
            afficherTitre("");
        } else{
            afficherTitre("REPONSE");
            System.out.println("eh non, il y avait une carte plus proche:");
            Carte mr=main.getCarte(bc);
            mr.setVisible();
            System.out.println(mr.toString());
            System.out.println("on les retire et on ajoute deux nouvelles cartes");
            // On retire les deux cartes du joueur puis il en re pioche deux 
            main.retirerCarte(choix);
            main.retirerCarte(bc);
            piocher();
            piocher();
            afficherTitre("");
        }
    }
    /**
     * 
     */
    public void afficherTitre(String mot){
        String res = "";
        if (mot.isBlank()){
            for (int i=0; i<80; i++){
                res += "-";
            }
        }
        else {
            int moitie = (80-mot.length())/2;
            for (int i=0; i<moitie;i++){
                res+= "-"; 
            }
            res += mot;
            for (int i=res.length(); i<80; i++){
                res+= "-"; 
            }
        }
        System.out.println(res); 
    }
        
    /**
    * Methode qui permet de jouer une partie complete
    */
    public void jouer(){
        // Tant que le joueur n'a pas la main vide ou que la pioche est vide
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
