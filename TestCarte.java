import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

	/**
	 * test sur consturcteur 
	 */
	public void test_1_constructeur(){
		Carte c = new Carte("Lapin");
	
		assertEquals("Le constructeur devrait creer une carte Lapin", c.getNom() , "Lapin");
	}

	public void test_2_ajouterCarac_noraml(){
		Carte c = new Carte("Lapin");
		Carac car = new Carac("Taille", 23);

		c.ajouterCarac(car);
		assertEquals("La caracteristique taille devrait exister", c.getCaracs()[0].getnomCarac(), "Taille"); 
		assertEquals("La taille devrait etre de 23cm", c.getCaracs()[0].getValeur(), 23.0); 

	}


}
