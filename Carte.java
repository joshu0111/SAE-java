class Carte {
    /** Attributs */
    private String nom; 
    private boolean visible ;
    private Carac [] caracs;

    /**
     * Constructeur avec nom
     * @param nom 
     */
    public Carte(String nom){
        // Verifie que le nom passer en parametre ne soit pas vide 
        if ( !(nom.isBlank()) ){
            this.nom = nom; 
        }else{
            this.nom = "Inconnu";
        }
    }

    /**
     * Constructeur avec 2 chaine
     * @param chaineNoms chaine de caractere avec les nom des caracteristiques 
     * @param chaineValeurs chaine de caractere avec la liste des valeurs des caracteristiques 
     */
    public Carte(String chaineNoms, String chaineValeurs){
        // Recuperation des valeurs individuellement 
        String [] listeNom = chaineNoms.split(";");
        String [] listeValeur = chaineValeurs.split(";");

        // Assignation du nom de la carte 
        this.nom = listeValeur[0];

        // Ajout de toutes les caracteristiques 
        if (listeValeur.length == listeNom.length){
            for (int i=1; i<listeValeur.length; i++){
                Carac newCar = new Carac(listeNom[i],Double.parseDouble(listeValeur[i]));
                this.ajouterCarac(newCar);
            }
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
            if (caracs[i].getNomCarac().equals(nom)){
                val=caracs[i].getValeur();
            }
        }
        return val;
    }

    /** Retourne la carte sur sa face visible
     */
    public void setVisible(){
        this.visible = true;
    }

    /** Methode toString
     */
    public String toString(){
        String res = "" + this.nom + " -> ";
        if ( visible == false ){
            for (int i=0; i<this.caracs.length; i++){
                res += "*"+this.caracs[i].getNomCarac()+" ???* ";
            }
        }else{
            for (int i=0; i<this.caracs.length; i++){
                res += "*"+this.caracs[i].getNomCarac()+" "+this.caracs[i].getValeur()+"* ";
            }
        }


        return res;
    }

    //---------- METHODES GETTER ------------

    /** methode getter pour attribut nom 
     */
    public String getNom(){
        return this.nom;
    }    

    /** methode getter pour attribut caracs
     */
    public Carac [] getCaracs(){
        return this.caracs;
    }   

    /** methode getter pour attribut visible
     */
    public boolean getVisible(){
        return this.visible;
    }  
}
