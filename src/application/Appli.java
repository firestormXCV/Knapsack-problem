package application;

import java.util.Scanner;

import resolutions.Glouton;
import resolutions.PSE;
import resolutions.progDynamique;
import structure.SacADos;
import tri.QuickSort;

public class Appli {

	public static void main(String[] args) {
		String saisie; 
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Veuillez saisir le chemin du fichier, le poids maximal du sac ainsi que la méthode de résolution : ");
		System.out.println("Exemple : items.txt 12 pse");
		System.out.print(">");
		boolean loop = true;
		while (loop ) {
			try {
				saisie = sc.nextLine();
				
				String[] saisietxt = saisie.split(" ");
		
				SacADos bag = new SacADos(saisietxt[0], Float.parseFloat(saisietxt[1]));
				
				String res = saisietxt[2];
				switch(res) {
					case "glouton":
						Glouton glouton = new Glouton();
						bag.setObjectList(QuickSort.QuickSort(bag.getObjectList(),(float) 0, (float) bag.getObjectList().size() - 1));
						glouton.resolution(bag);
						System.out.println(bag.toStringIn());
						loop = false;
						break;
					case "prog.dynamique":
						progDynamique progDynamique = new progDynamique();
						progDynamique.resolution(bag);
						System.out.println(bag.toStringIn());
						loop = false;
						break;
					case "pse":
						PSE pse = new PSE();
						pse.resolution(bag);
						System.out.println(bag.toStringIn());
						loop = false;
						break;	
					default:
						System.out.println("Saisie non valide merci de recommencer");
				}
			} catch (Exception e) {
				System.out.println("Saisie non valide merci de recommencer");
			}
			
		}
		
//		SacADos sacGlouton = new SacADos("items.txt", 8);
//		SacADos sacDynamique = new SacADos("items.txt", 8);
//		SacADos sacPSE = new SacADos("items.txt", 8);
//
//        Glouton glouton = new Glouton();
//        progDynamique progDynamique = new progDynamique();
//		PSE pse = new PSE();
//		
//		sacGlouton.setObjectList(QuickSort.QuickSort(sacGlouton.getObjectList(),(float) 0, (float) sacGlouton.getObjectList().size() - 1));
//        
//		glouton.resolution(sacGlouton);
//		progDynamique.resolution(sacDynamique);
//		pse.resolution(sacPSE);
//
//		System.out.println(sacGlouton.toStringIn());
//		System.out.println("**********************************");
//		System.out.println(sacDynamique.toStringIn());
//		System.out.println("**********************************");
//		System.out.println(sacPSE.toStringIn());
	}
}

