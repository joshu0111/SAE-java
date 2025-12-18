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
            main.ajouterCarteFin();
        }
    }
    
    /**
     * Une manche de jeu
     */
    public void jouerUneManche(){
        Scanner sc=new Scanner(System.in);
        Random rm=new Random();
    }

}


