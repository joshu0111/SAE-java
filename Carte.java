class Carte {
    /** Attributs */
    private String nom; 
    private boolean visible ;
    private Carac [] caracs;

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
        // Assignation des anciennes valeurs 
        int longueurThisCaracs = this.caracs.length; 
        Carac [] newCaracs = new Carac[longueurThisCaracs+1];
        for (int i=0; i<longueurThisCaracs; i++){
            newCaracs[i] = this.caracs[i];
        }

        // Assignation nouvelle valeur 
        newCaracs[newCaracs.length-1] = c;

        // Remplacement par le nouveau tableau 
        this.caracs = newCaracs;
    }

    /** Retourne la valeur de la caracteristique dont le nom est passe en parametre 
     * @param nom corrrespond au nom de la caracteristique dont on veut la valeur
     */
    public double getValeur(String nom){
        if (nom.equals(Carac.nomCarac)){
            return Carac.getValeur();
        } else {
            return -1.0;
        }
    }

    /** Retourne la carte sur sa face visible
     */
    public void setVisible(){
        this.visible = true;
    }
    
    /** methode getter pour attribut nom 
     */
    public void getNom(){
        return this.nom;
    }    

    /** methode getter pour attribut  
     */
    public void getCaracs(){
        return this.caracs;
    }    
}
