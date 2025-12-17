class Carte {
    /** Attributs */
    String nom; 
    boolean visible ;
    Carac [] caracs;

    /**
     * Constructeur 
     * @param nom 
     */
    public Carte(String nom){
        // Verifie que le nom passer en parametre ne soit pas vide 
        if ( !(nom.isBlank()) ){
            this.nom = nom; 
        }
    }

    /** Ajoute la caracteristiques passee en parametre a la liste des caracteristiques 
     * @param c correspond a la nouvel caracteristique
     */
    public void ajouterCarac(Carac c){
        longueurThisCaracs = this.caracs.length; 
        Carac [] newCaracs = new Carac[longueurThisCaracs];
        for (int i=0; i<longueurThisCaracs; i++){
            newCaracs[i] = this.caracs
        }

    }

    /** Retourne la valeur de la caracteristique dont le nom est passe en parametre 
     * @param nom corrrespond au nom de la caracteristique dont on veut la valeur
     */
    public double getValeur(String nom){

    }

}
