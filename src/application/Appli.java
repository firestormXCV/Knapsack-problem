package application;

public class Appli {

	public static void main(String[] args) {
		
		SacADos bag = new SacADos(15);
		SacADos rempli = new SacADos("items.txt", 20);
		
		System.out.println(rempli.toString());
		
	}

	/**
	 * A faire parce que ca marche pas :
	 * 
	 * - faire l'algo glouton 
	 * - remplacer Colections.sort par notre algo de quick sort 
	 */
}

