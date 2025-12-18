import java.util.Random;

class PaquetCartes{
    private Carte[] cartes;

    /**
     * Constructeur vide
     */
    public PaquetCartes(){
        this.cartes = new Carte[0];
    }
    /**
     * Constructeur a partir d'un tableau de cartes
     * @param c correspond au tableau de cartes
     */
    public PaquetCartes(Carte[] c){
        this.cartes=c;
    }
    /**
     * Constructeur a partir d'un fichier 
     * @param NomFichier corresponds au fichier 
     */ 
    public PaquetCartes(String NomFichier){
        // Creation d'un objet LectureFichier correspondant au fichier 
        LectureFichier fichier= new LectureFichier(NomFichier);
        String lignes = fichier.lireFichier();
        // Cette ligne correspond au nom de chaque colonne
        String caractere=lignes[0];
        // Creation d'un tableay vide
        this.cartes=new Carte[0];
        for (int i=0;i<lignes.length;i++){
            Carte c = new Carte(caractere, ligne[i]);
            this.ajouterCarteFin(c)
        }
    }
    /**
     * Methode permettant d'ajouter une carte a notre paquets de cartes
     * @param c Carte c qui est ajouter au paquet
     */
    public void ajouterCarteFin(Carte c){
        // Creation d'un nouveau tableau avec une taille taille+1 que l'ancien pour pouvoir rajouter la carte
        Carte[] nv=new Carte[cartes.length+1];
        // Ajout de tout les valeurs de l'ancien tableau dans le nouveau
        for (int i=0;i<cartes.length;i++){
            nv[i]=cartes[i];
        }
        // Ajout du nouveau tableau a la place de l'ancien
        nv[cartes.length]=c;
        this.cartes=nv;
    }
    /**
     * Methode permettant de supprimer une carte a la place "place"
     * @param place place de la carte qu'on souhaite retirer
     */
    public Carte retirerCarte(int place){
        // Verifications si l'indice place est bien compris dans la taille du tableau
        if (place<0 || place>=cartes.length){
            return null;
        }
        Carte supp=cartes[place];
        Carte[] nv=new Carte[cartes.length-1];
        int index=0;
        for (int i=0;i<cartes.length;i++){
            if (cartes[i]!=cartes[place]){
                nv[index]=cartes[i];
                index++;
            }
        }
        this.cartes=nv;
        return supp;
    }
    /**
     * Methode qui pioche aleatoirement une carte, la retire de la pioche puis la retire
     */
    public Carte piocherHasard(){
        // Si la pioche est vide on retourne null
        if (cartes.length==0){
            return null;
        }
        Random rdm = new Random();
        int indice=rdm.nextInt(cartes.length);
        Carte cartePioche=cartes[indice];
        retirerCarte(indice);
        return cartePioche;
    }
    /**
     * Methode 
     */
    public int trouverCarteProche(Carte c, String nc){
    }
    /**
     * methode getter pour le nombre de carte
     */
    public int getNbCartes(){
        return this.cartes.length;
    }
    /**
     * methode getter pour la carte correspond a la place 
     * @param place correspond a la place de la carte rechercher
     */
    public Carte getCarte(int place){
        if (place<0 || place>=cartes.length){
            return null;
        }
        return cartes[place];
    }
}
