import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){
	System.out.println(Arrays.toString(data));
	Random rand = new Random();
	int randI = rand.nextInt(end-start) + 1 + start;
	int num = data[randI];
    	System.out.println("randI " + randI + " num " + num);
    	swap(data, randI, end);
    	System.out.println(Arrays.toString(data));
	int b = end-1;
	int a = start;
	while(a <= b){
	    if(data[a] < num){
		a++;
	    }else if(data[a] >= num){
		swap(data, a, b);
		b--;
	    }
	    // System.out.println("a " + a + " b " + b);
	    System.out.println(Arrays.toString(data));
	}
	swap(data, end, a);
	System.out.println(Arrays.toString(data));
	return a;
    }

    public static void swap(int[] data, int orig, int replace){
	int temp = data[orig];
	data[orig] = data[replace];
	data[replace] = temp;
    }
    
    // PARTITION: using separate array
    // 	int[] temp = new int[end-start+1];
    // 	for(int i = 0; i < temp.length; i++){
    // 	    temp[i] = data[start+i];
    // 	}
    // 	Random rand = new Random();
    // 	int randI = rand.nextInt(end-start)+1;
    // 	int num = temp[randI];
    // 	int s = 0;
    // 	int e = temp.length-1;
    // 	for(int i = 0; i < temp.length; i++){
    // 	    if(i != randI){
    // 		if(temp[i] > num){
    // 		    data[e+start] = temp[i];
    // 		    e--;
    // 		}else{
    // 		    data[s+start] = temp[i];
    // 		    s++;
    // 		}
    // 	    }
	  
    // 	}
    // 	data[e+start] = num;
    // 	return e+start;
    // }

    public static int quickselect(int[] data, int k){
	return quickSelectH(data, k, 0, data.length-1);
    }

    public static int quickSelectH(int[] data, int k, int start, int end){
	int n = part(data, start, end);
	if(k == n){
	    return data[n];
	}else{
	    if(k < n){
		return quickSelectH(data, k, 0, n-1);
	    }
	    return quickSelectH(data, k, n+1, data.length-1);
	}
    }

    public static int[] quickSort(int[] data){
	return quickSortH(data, 0, data.length-1);
    }

    public static void quickSortH(int[] data, int left, int right){
	if(left == right){
	    return;
	}if(left < right){
	    p = part(data, left, right);
	    quickSortH(data, 0, left-1);
	    quickSortH(data, left+1, right);
	}
    }
		
	    

    public static void main(String[] args){
	int[] ary = {77, 100, 2, 41, 0};
	int[] ary2 = {99, 99, 99, 0, 2, 4, 3, 1, 99, 99, 99};
	//System.out.println(part(ary2, 3, 7));
	System.out.println(part(ary, 0, 4));
    }
}
