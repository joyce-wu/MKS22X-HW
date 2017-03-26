import java.util.*;

public class Merge{
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
	    System.out.println(Arrays.toString(destination));
	}
    }

    public static void mergesort(int[] ary){
	if(ary.length == 1){
	    return;
	}else{
	    int[] left = new int[ary.length/2];
	    for(int i = 0; i < left.length; i++){
		left[i] = ary[i];
	    }
	    int[] right = new int[ary.length/2];
	    for(int i = 0, n = ary.length/2; i < right.length; i++, n++){
		right[i] = ary[n];
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }

    public static void main(String[] args){
	int[] a = {-1, 2, 4, 6, 8, 10, 1000, 1000, 1000, 2011, 2013, 44444};
	int[] b = {1, -1, 4, 3, 7, 2};
	int[] d = new int[a.length + b.length];
	int[] c = {9, 10, 14};
	int[] e = {};
	int[] hi = new int[3];
	
	//merge(a, b, d);
	mergesort(b);
	System.out.println(Arrays.toString(b));
    }
}
