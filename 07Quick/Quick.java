import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){	
    	Random rand = new Random();
    	int randI = rand.nextInt(end-start) + 1 + start;
    	int num = data[randI];
    	swap(data, randI, end);
    	int b = end-1;
    	int a = start;
    	while(a <= b){
    	    if(data[a] < num){
    		a++;
    	    }else if(data[a] >= num){
    		swap(data, a, b);
    		b--;
    	    }
    	}
    	swap(data, end, a);
    	return a;
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

    public static void swap(int[] data, int orig, int replace){
	    int temp = data[orig];
	    data[orig] = data[replace];
	    data[replace] = temp;
	}
    
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

    public static void quickSort(int[] data){
	if(data.length == 0){
	    return;
	}else{
	    quickSortH(data, 0, data.length-1);
	}
    }

    public static void quickSortH(int[] data, int start, int end){
	if(start == end){
	    return;
	}
	//System.out.println("start " + start + " end " + end);
    	Random rand = new Random();
	int randI = rand.nextInt(end-start) + 1 + start;
	int num = data[randI];
	swap(data, randI, end);
	int i = start;
	int lt = start;
	int gt = end;
	while(i <= gt){
	    if(data[i] == num){
		i++;
	    }else if(data[i] < num){
		swap(data, i, lt);
		lt++;
		i++;
	    }else{
		swap(data, i, gt);
		gt--;
	    }
	}
	//System.out.println(Arrays.toString(data));
	if(lt != 0){
	    quickSortH(data, start, lt-1);
	}
	quickSortH(data, gt, end);
    }

    public static void main(String[] args){
	int[] ary = {77, 100, 2, 41, 0};
	int[] ary2 = {99, 99, 99, 0, 2, 4, 3, 1, 99, 99, 99};
	int[] ary3 = {-44, 75, 100, 100, 22, 34, 51, 78, 42, 109, 88, 100, 99, 99, 201, 314, 57, 89, 100, -7, -11};
	int[] randomA = new int[5000];
	Random ran = new Random();
	for(int i = 0; i < 5000; i++){
	    randomA[i] = ran.nextInt(5000) + 1;
	}
	int[] h = {};
	int[] bye = {1};
	quickSort(h);
	quickSort(bye);
	System.out.println(Arrays.toString(bye));
	System.out.println(Arrays.toString(h));
	//System.out.println(Arrays.toString(randomA));
	//quickSort(randomA);
	//System.out.println(Arrays.toString(randomA));
	//quickSort(ary);
	//System.out.println(Arrays.toString(ary));
	//System.out.println(partMax(ary2, 3, 7));
    }
}
