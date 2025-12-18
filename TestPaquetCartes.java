import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquetCartes {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquetCartes(), args);
	}

	public void test_1_constructeur_vide(){
		PaquetCartes p = new PaquetCartes();
		assertEquals("Il ne devrait avoir aucune carte", 0, p.getNbCartes());
	}

	public void test_2_constructeur_avec_carte(){
		Carte [] c ={new Carte("Lapin")};
		PaquetCartes p = new PaquetCartes(c);
		assertEquals("Il devrait y avoir une carte", 1, p.getNbCartes());
		assertEquals("La carte devrait etre Lapin", "Lapin", p.getCarte(0).getNom());
	}

	public void test_3_constructeur_avec_fichier(){
		PaquetCartes p = new PaquetCartes("../cartes/fichierTest.csv");
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		assertEquals("Le nom de la 1ere carte devrait etre lapin nain", "lapin nain", p.getCarte(0).getNom());
		assertEquals("La caracteristiques taille devrait etre egal a 19.0", 19.0, p.getCarte(0).getValeur("taille"));
		assertEquals("La caracteristiques poids devrait etre egal a 1.3", 1.3, p.getCarte(0).getValeur("poids"));
		assertEquals("Le nom de la 2eme carte devrait etre saint Bernard", "saint Bernard", p.getCarte(1).getNom());
		assertEquals("La caracteristiques taille devrait etre egal a 80.0", 80.0, p.getCarte(1).getValeur("taille"));
		assertEquals("La caracteristiques poids devrait etre egal a 92.0", 92.0, p.getCarte(1).getValeur("poids"));
	}

	public void test_4_ajouterCarteFin(){
		PaquetCartes p = new PaquetCartes("../cartes/fichierTest.csv");
		Carte c = new Carte("tigre");
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		p.ajouterCarteFin(c);
		assertEquals("Le nombre de carte dans le paquet devrait etre 3", 3, p.getNbCartes());
		assertEquals("La derniere carte devrait s'appelait tigre", "tigre", p.getCarte(2).getNom());
	}

	public void test_5_ajouterCarteFin_paquet_vide(){
		PaquetCartes p = new PaquetCartes();
		Carte c = new Carte("tigre");
		assertEquals("Le nombre de carte dans le paquet devrait etre 0", 0, p.getNbCartes());
		p.ajouterCarteFin(c);
		assertEquals("Le nombre de carte dans le paquet devrait etre 3", 3, p.getNbCartes());
	}

	public void test_6_retirerCarte(){
		PaquetCartes p = new PaquetCartes("../cartes/fichierTest.csv");
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		p.retirerCarte(1);
		assertEquals("Le nombre de carte dans le paquet devrait etre 1", 1, p.getNbCartes());
		assertEquals("La derniere carte devrait s'appelait lapin nain", "lapin nain", p.getCarte(0).getNom());
	}

	public void test_6_retirerCarte_paquet_vide(){
		PaquetCartes p = new PaquetCartes();
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		p.retirerCarte(1);
		assertEquals("Le nombre de carte dans le paquet devrait etre 1", 1, p.getNbCartes());
		assertEquals("La derniere carte devrait s'appelait lapin nain", "lapin nain", p.getCarte(0).getNom());
	}

	public void test_7_piocherHasard(){
		PaquetCartes p = new PaquetCartes("../cartes/fichierTest.csv");
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		assertEquals("Le nombre de carte dans le paquet devrait etre 2", 2, p.getNbCartes());
		
		assertEquals("Le nombre de carte dans le paquet devrait etre 1", 1, p.getNbCartes());
	}



}

