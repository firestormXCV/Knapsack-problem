package application;

import java.util.ArrayList;
import java.util.Collections;

public class Appli {

	public static void main(String[] args) {
		
		SacADos rempli = new SacADos("items.txt", 2);
		rempli.setObjectList(QuickSort.QuickSort(rempli.getObjectList(),(float) 0, (float) rempli.getObjectList().size() - 1));
		Glouton.glouton(rempli);
		System.out.println(rempli.toStringIn());
		
		System.out.println("**********************************");
		
		SacADos sacDynamique = new SacADos("items.txt", 2);
		progDynamique.progDynamique(sacDynamique);
		System.out.println(sacDynamique.toStringIn());

		
	}

	/**
	 * TODO
	 * - ecrire la méthode pse 
	 * - tester la méthode pse une fois fini 
	 * - faire des tests unitaires ? 
	 * - supprimer les getters et setters non utilisés 
	 */
}

