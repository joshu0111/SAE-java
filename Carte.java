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

        // Verifie qu'il y ai des valeurs dans l'attribut carac
        if (this.caracs == null){  

            Carac [] newCaracs = {c};
            this.caracs = newCaracs;
        }else{
            // Assignation des anciennes 
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


    }


     /** Retourne la valeur de la caracteristique dont le nom est passe en parametre 
     * @param nom corrrespond au nom de la caracteristique dont on veut la valeur
     */
    public double getValeur(String nom){
        double val=-1.0;
        for (int i=0;i<caracs.length;i++){
            if (caracs[i].getnomCarac().equals(nom)){
                val=caracs[i].getValeur();
            }
        }
        return val;
    }

    /** Retourne la carte sur sa face visible
     */
    public boolean setVisible(){
        return this.visible = true;
    }
    
    /** methode getter pour attribut nom 
     */
    public String getNom(){
        return this.nom;
    }    

    /** methode getter pour attribut  
     */
    public Carac [] getCaracs(){
        return this.caracs;
    }    
}
