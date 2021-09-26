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
	            //swap(list, i, j);
	        }
	    }
	    Collections.swap(list, i+1, (int) high);
	    //swap(list, i + 1, high);
	    return (i + 1);
	}
    
    
    static ArrayList<Objet> QuickSort(ArrayList<Objet> list, float first, float last) {
        float pivot; 
        
        if (first < last) {
            pivot = ChoosePi(list, first, last);
            float pi = repartition(list, first, last);
            pivot = list.size() - 1;
            list = QuickSort(list, first, pi -1 );
            list = QuickSort(list, pi +1, last);
            
        }
        return list;
    }
    
//    static void swap(ArrayList<Objet> list, int x, int y) {
//        int tmp = t[x];
//        t[x] = t[y];
//        t[y] = tmp;
//    }
    
    static float ChoosePi(ArrayList<Objet> list, float d, float f) {
        return list.get((int) d).getRatio();
    }
}
