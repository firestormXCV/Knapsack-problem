package application;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    
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
    
    
    private final static ArrayList<Objet> order(ArrayList<Objet> list, float first, float last) {
        float pivot; 
        
        if (first < last) {
            pivot = ChoosePi(list, first, last);
            float pi = repartition(list, first, last);
            pivot = list.size() - 1;
            list = order(list, first, pi -1 );
            list = order(list, pi +1, last);
            
        }
        return list;
    }
    
    static float ChoosePi(ArrayList<Objet> list, float d, float f) {
        return list.get((int) d).getRatio();
    }
    
    public final static ArrayList<Objet> QuickSort(ArrayList<Objet> list, float first, float last) {    		
    	order(list,first,last);
		Collections.reverse(list);
		return list;
    }
}
