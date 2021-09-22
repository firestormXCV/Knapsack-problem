package application;

public class QuickSort {
    
	static int repartition(int[] arr, int low, int high)
	{
	      
	    // pivot
	    int pivot = arr[high]; 
	      
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1); 
	  
	    for(int j = low; j <= high - 1; j++)
	    {
	          
	        // If current element is smaller 
	        // than the pivot
	        if (arr[j] < pivot) 
	        {
	              
	            // Increment index of 
	            // smaller element
	            i++; 
	            change(arr, i, j);
	        }
	    }
	    change(arr, i + 1, high);
	    return (i + 1);
	}
    
    
    static int[] QuickSort(int[] arr, int first, int last) {
        int pivot; 
        
        if (first < last) {
            pivot = ChoosePi(arr, first, last);
            int pi = repartition(arr, first, last);
            pivot = arr[arr.length-1];
            arr = QuickSort(arr, first, pi -1 );
            arr = QuickSort(arr, pi +1, last);
            
        }
        return arr;
    }
    
    static void change(int[]t, int x, int y) {
        int tmp = t[x];
        t[x] = t[y];
        t[y] = tmp;
    }
    
    static int ChoosePi(int[] t, int d, int f) {
        return t[d];
    }
}
