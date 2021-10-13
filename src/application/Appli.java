package application;

import java.util.ArrayList;
import java.util.Collections;

public class Appli {

	public static void main(String[] args) {
		
		SacADos rempli = new SacADos("items.txt", 2);
//		rempli.setObjectList(QuickSort.QuickSort(rempli.getObjectList(),(float) 0, (float) rempli.getObjectList().size() - 1));
//		Glouton.glouton(rempli);
//		System.out.println(rempli.toStringIn());
		
		SacADos sacDynamique = new SacADos("dynamique.txt", 12);
		progDynamique.progDynamique(sacDynamique);
		System.out.println(sacDynamique.toString());

		
	}

	/**
	 * TODO
	 * - tester si les méthodes avec les coeff fonctionnent bien 
	 * - ecrire la méthode pse 
	 * - tester la méthode pse une fois fini 
	 * - modifier le tostring du sac ? 
	 * - faire des tests unitaires ? 
	 */
}

