package application;

import java.util.ArrayList;
import java.util.Collections;

public class Appli {

	public static void main(String[] args) {
		
		SacADos rempli = new SacADos("items.txt", 3);
		
		rempli.setObjectList(QuickSort.QuickSort(rempli.getObjectList(),(float) 0, (float) rempli.getObjectList().size() - 1));
		
		Glouton.glouton(rempli);
		
		System.out.println(rempli.toStringIn());
		
	}

	/**
	 * A faire parce que ca marche pas :
	 * 
	 * - faire l'algo glouton 
	 */
}

