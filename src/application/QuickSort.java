package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Pasquier, Pessey
 * @brief Classe QuickSort
 */
public class QuickSort {
    
	/**
	 * @brief
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 */
	static int repartition(ArrayList<Objet> list, float low, float high) {
	    float pivot = list.get((int) high).getRatio(); 
	    int i = (int) (low - 1); 
	    
	    for(int j = (int) low; j <= high - 1; j++){
	        if (list.get(j).getRatio() < pivot){
	            i++;
	             Collections.swap(list, i, j);
	        }
	    }
	    Collections.swap(list, i+1, (int) high);
	    return (i + 1);
	}
    
    /**
     * @brief 
     * @param list liste des objets
     * @param first 
     * @param last
     * @return la liste des objets triee par ordre croissant 
     */
    private final static ArrayList<Objet> order(ArrayList<Objet> list, float first, float last) {
        float pivot; 
        
        if (first < last) {
            pivot = ChoosePi(list, first);
            float pi = repartition(list, first, last);
            pivot = list.size() - 1;
            list = order(list, first, pi -1 );
            list = order(list, pi +1, last);
            
        }
        return list;
    }
    
    /**
     * @brief Methode permettant de choisir un pivot dans la liste 
     * @param list liste des objets
     * @param d indice du premier objet de la liste
     * @return l'indice du pivot dans la liste
     */
    static float ChoosePi(ArrayList<Objet> list, float d) {
        return list.get((int) d).getRatio();
    }
    
    /**
     * @brief 
     * @param list
     * @param first
     * @param last
     * @return
     */
    public final static ArrayList<Objet> QuickSort(ArrayList<Objet> list, float first, float last) {    		
    	order(list,first,last);
		Collections.reverse(list);
		return list;
    }
}
