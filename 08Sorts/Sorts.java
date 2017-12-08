import java.util.*;

public class Sorts {
    public static String name(){
	return "10,Chan,Nicholas";
    }

    public static boolean isSorted(int[]ary){                                   
        for(int i = 0; i < ary.length - 1 ; i++){                              
            if(ary[i] > ary[i+1]){                                              
                return false;                                                   
            }                                                                   
        }                                                                       
        return true;                                                           
    }
    
    public static void selectionSort(int[] data) {
	for (int x = 0; x < data.length - 1; x++) {
	    int lowest = x;
	    for (int i = x + 1; i < data.length; i++) {
		if (data[lowest] > data[i]) {
		    lowest = i;
		}
	    }
	    int c = data[x];
	    data[x] = data[lowest];
	    data[lowest] = c;
	}
    }

    public static void insertionSort(int[] data) {
	for (int x = 0; x < data.length - 1; x++) {
	    for (int i = x + 1; i > 0; i--) {
		if (data[i] < data[i - 1]) {
		    int c = data[i];
		    data[i] = data[i - 1];
		    data[i - 1] = c;
		}
	    }
	}
    }

     /* Probably useful in future
    public static void swap (int[] ary, int a, int b) {
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
     */
    /*
    public static void main(String[]args){                                      
        int[] randish = new int[15];                                            
        for(int i = 0 ; i < randish.length; i++){                               
            randish[i] =(int)(Math.random()*100);                              
        }                                         
        System.out.println(name());
        System.out.println(Arrays.toString(randish));                           
        selectionSort(randish);                                                 
        System.out.println(Arrays.toString(randish));                           
    } 
    */                                      
    
}


