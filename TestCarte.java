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

	public void test_1_constructeur(){
		Carte c = new Carte("Lapin");
	
		assertEquals("Le constructeur devrait creer une carte Lapin", c.getNom() , "Lapin");
	}

	public void test_2_constructeur_chaine_vide(){
		Carte c = new Carte("");
	
		assertEquals("Le constructeur devrait creer une carte Lapin", c.getNom() , "Inconnu");
	}

	public void test_3_ajouterCarac_noraml(){
		Carte c = new Carte("Lapin");
		Carac car = new Carac("Taille", 23);

		c.ajouterCarac(car);
		assertEquals("La caracteristique taille devrait exister", c.getCaracs()[0].getNomCarac(), "Taille"); 
		assertEquals("La taille devrait etre de 23cm", c.getCaracs()[0].getValeur(), 23.0); 
	}


	public void test_4_ajouterCarac_plusieurs_caracs(){
		Carte c = new Carte("Lapin");
		Carac car1 = new Carac("Taille", 23);
		Carac car2 = new Carac("Poids", 20);
		

		c.ajouterCarac(car1);
		c.ajouterCarac(car2);
		assertEquals("La caracteristique taille devrait exister", c.getCaracs()[0].getNomCarac(), "Taille"); 
		assertEquals("La taille devrait etre de 23cm", c.getCaracs()[0].getValeur(), 23.0); 

		assertEquals("La caracteristique taille devrait exister", c.getCaracs()[1].getNomCarac(), "Poids"); 
		assertEquals("La taille devrait etre de 20kg", c.getCaracs()[1].getValeur(), 20.0); 
	}

	public void test_5_Carte_getValeur_normal(){
		Carac caractere = new Carac("Voller", -100.0);
		Carte ct = new Carte("Toto");
		ct.ajouterCarac(caractere);

		assertEquals("La valeur de la caracteristique voller doit etre -100.0", -100.0, ct.getValeur("Voller"));
	}

	public void test_6_Carte_getValeur_normal(){
		Carac caractere = new Carac("Voller", -100.0);
		Carte ct = new Carte("Toto");
		ct.ajouterCarac(caractere);

		assertEquals("La valeur de la caracteristique voller doit etre -100.0", -1.0, ct.getValeur("Manger"));
	}

	public void test_7_setVisible_defaut(){
		Carte c = new Carte("Lapin");
		assertEquals("La carte ne doit pas etre visible", false, c.getVisible());
	}

	public void test_8_setVisible_visible(){
		Carte c = new Carte("Lapin");
		c.setVisible();
		assertEquals("La carte devrait etre visible", true, c.getVisible());
	}

	public void test_9_constructeur_par_chaine_normal(){
		String noms = "nom;Taille;Poids";
		String valeurs = "Lapin;40.0;5.0";
		Carte c = new Carte(noms, valeurs);
		assertEquals("Le nom de la carte devrait etre Lapin", "Lapin", c.getNom());
		assertEquals("La carte a une caracteristique au nom de Taille", "Taille", c.getCaracs()[0].getNomCarac());
		assertEquals("La carte a une caracteristique au nom de Poids", "Poids", c.getCaracs()[1].getNomCarac());
		assertEquals("La carte a une caracteristique au nom de Poids avec une valeur de 40", 40.0, c.getCaracs()[0].getValeur());
		assertEquals("La carte a une caracteristique au nom de Poids avec une valeur de 5", 5.0, c.getCaracs()[1].getValeur());
	}

	public void test_10_constructeur_par_chaine_sans_caracteristiques(){
		String noms = "nom";
		String valeurs = "Lapin";
		Carte c = new Carte(noms, valeurs);
		assertEquals("Le nom de la carte devrait etre Lapin", "Lapin", c.getNom());
		assertEquals("Il ne devrait pas y avoir de caracteristiques", null, c.getCaracs());
	}

	public void test_11_toString_non_visible(){
		String noms = "nom;Taille;Poids";
		String valeurs = "Lapin;30;7";
		Carte c = new Carte(noms, valeurs);
		assertEquals("Le chaine renvoyee devrait etre : Lapin -> *Taille ???* *Poids ???*", "Lapin -> *Taille ???* *Poids ???* ", c.toString());
	}

	public void test_12_toString_visible(){
		String noms = "nom;Taille;Poids";
		String valeurs = "Lapin;30;7";
		Carte c = new Carte(noms, valeurs);
		c.setVisible();
		assertEquals("Le chaine renvoyee devrait etre : Lapin -> *Taille 30.0* *Poids 7.0*", "Lapin -> *Taille 30.0* *Poids 7.0* ", c.toString());
	}
}
