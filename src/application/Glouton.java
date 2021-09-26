package application;

import java.util.ArrayList;
import java.util.Collections;

public class Glouton {
		
	// mettre le quick sort ici 
	
	//appel de quicksort sur le tableau des objets et trié par ordre décroissant 
	
	//2 sacs 
	
	//sac1 avec tous les objets et sans poids 
	//on trie le sac avel l'algo (trie du tableau du sac)
	
	//une fois trié on passe le tableau du sac avec glouton 
	
	ArrayList<Objet> list = new ArrayList<>();
	Collections.sort(list);
	
	// comment faire le lien entre ratio et objet 
	
	public void glouton(SacADos bag, ArrayList list) {
		float weight = bag.getCurrentWeight();
		for(int i = 0; i < list.size(); i++) {
			if(weight <= bag.getMaxWeight()) {
				bag.addObject(list.get(i));
			}
		}
	}
}
