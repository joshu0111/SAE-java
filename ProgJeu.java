import java.util.Scanner;

class ProgJeu{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Quel est le nom de votre fichier : ");
        String nomf=sc.nextLine();
        System.out.println("Quel est le nombre de carte que vous voulez piocher : ");
        int nb=sc.nextInt();
        Jeu j=new Jeu(nomf, nb);
        j.jouer();
    }
}
