package application;

public class Appli {

	public static void main(String[] args) {
		
		SacADos bag = new SacADos(15);
		
		String s = bag.readTextFile("items.txt");
		
		//sysout + ctl esp
		System.out.println(s);
		
	}

	/**
	 * A faire parce que ca marche pas :
	 * 
	 * - voir la méthode readTextFile
	 * - revoir l'organistion des méthodes pour ajouter des objets à un sac 
	 * - faire l'algo glouton 
	 * - remplacer Colections.sort par notre algo de quick sort 
	 */
}

