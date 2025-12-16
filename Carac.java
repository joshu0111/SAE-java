class Carac{
    /* Attributs */
    String nomCarac;
    double valeur;

    /** Constructeurs avec paramatre 
    * @param nc chaine de caractere qui correspond au nom de la caracteristique 
    * @param val reel qui correspond a la valeur de la caracteristique 
    */
    public Carac(String nc, double val){
        if (nc.equals("")){
            this.nomCarac="Inconnu";
        }
        else {
            this.nomCarac=nc;
        }
        this.valeur=val;
    }

    /**
     * Methode getter pour l'attribut valeur 
     */
    public double getValeur(){
        return this.valeur;
    }
    
    /**
     * Methode etreEgal qui renvoie truesi le nom passer en parametre est egal a l'attribut nomCarac
     * @param nom qui permet 
     */
    public boolean etreEgal(String nom){
        if (nom.equals(this.nomCarac)){
            return true;
        }
        else {
            return false;
        }
    }
}
