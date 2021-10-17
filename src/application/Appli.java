package application;

import resolutions.Glouton;
import resolutions.PSE;
import resolutions.progDynamique;
import structure.SacADos;
import tri.QuickSort;

public class Appli {

	public static void main(String[] args) {
		
		SacADos sacGlouton = new SacADos("items.txt", 8);
		SacADos sacDynamique = new SacADos("items.txt", 8);
		SacADos sacPSE = new SacADos("items.txt", 8);

        Glouton glouton = new Glouton();
        progDynamique progDynamique = new progDynamique();
		PSE pse = new PSE();
		
		sacGlouton.setObjectList(QuickSort.QuickSort(sacGlouton.getObjectList(),(float) 0, (float) sacGlouton.getObjectList().size() - 1));
        
		glouton.resolution(sacGlouton);
		progDynamique.resolution(sacDynamique);
		pse.resolution(sacPSE);

		System.out.println(sacGlouton.toStringIn());
		System.out.println("**********************************");
		System.out.println(sacDynamique.toStringIn());
		System.out.println("**********************************");
		System.out.println(sacPSE.toStringIn());

		
	}

	/**
	 * TODO
	 * - faire des tests unitaires ? 
	 */
}

