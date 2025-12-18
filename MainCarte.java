class MainCarte{
    public static void main(String [] args){
        LectureFichier f = new LectureFichier("../cartes/animaux.csv");
        String [] lignes = f.lireFichier();
        Carte c;
        for (int i=1; i<lignes.length; i++){
            c = new Carte(lignes[0], lignes[i]);
            System.out.println(c.toString());
            c.setVisible();
            System.out.println(c.toString());
        }
    }
}
