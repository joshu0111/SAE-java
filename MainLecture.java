class MainLecture{
    public static void main(String [] args){
        LectureFichier f = new LectureFichier("../cartes/animaux.csv");
        String [] ligne = f.lireFichier();
        for (int i=0; i<ligne.length; i++){
            System.out.println(ligne[i]);
        }
    }
}
