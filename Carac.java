class Carac{
    String nomCarac;
    double valeur;

    public Carac(String nc, double val){
        if (nc.equals("")){
            this.nomCarac="Inconnu";
        }
        else {
            this.nomCarac=nc;
        }
        this.valeur=val;
    }

    public double getValeur(){
        return this.valeur;
    }
    
    public boolean etreEgal(String nom){
        if (nom.equals(this.nomCarac)){
            return true;
        }
        else {
            return false;
        }
    }
}
