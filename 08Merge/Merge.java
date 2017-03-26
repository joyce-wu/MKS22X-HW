import java.util.*;

public class Merge{
    public static void mergesort(int[] ary){
    }

    public static void merge(int[] a, int[] b, int[] destination){
	int ai = 0;
	int bi = 0;
	for(int i = 0; i < destination.length; i++){
	    if(ai >= a.length){
		copyRest(destination, i, b, bi);
		return;
	    }else if(bi >= b.length){
		copyRest(destination, i, a, ai);
		return;
	    }else if(a[ai] <= b[bi]){
		destination[i] = a[ai];
		ai++;
	    }else if(a[ai] > b[bi]){
		destination[i] = b[bi];
		bi++;
	    }
	}
    }

    public static void copyRest(int[] destination, int index, int[] a, int aI){
	for(int i = index; i < destination.length; i++){
	    destination[i] = a[aI];
	    aI++;
	}
    }

    public static void main(String[] args){
	int[] a = {-1, 2, 4, 6, 8, 10, 1000, 1000, 1000, 2011, 2013, 44444};
	int[] b = {1, 3, 5, 6, 7, 9};
	int[] d = new int[a.length + b.length];
	int[] c = {9, 10, 14};
	int[] e = {};
	int[] hi = new int[3];
	
	merge(a, b, d);
	System.out.println(Arrays.toString(d));
    }
}
