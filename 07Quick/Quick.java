import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){
	int[] temp = new int[end-start+1];
	for(int i = 0; i < temp.length; i++){
	    temp[i] = data[start+i];
	}
	Random rand = new Random();
	int randI = rand.nextInt(end-start)+1;
	int num = temp[randI];
	int s = 0;
	int e = temp.length-1;
	for(int i = 0; i < temp.length; i++){
	    if(i != randI){
		if(temp[i] > num){
		    data[e+start] = temp[i];
		    e--;
		}else{
		    data[s+start] = temp[i];
		    s++;
		}
	    }
	  
	}
	data[e+start] = num;
	return e+start;
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
	    

    public static void main(String[] args){
	int[] ary = {77, 100, 2, 41, 0};
	int[] ary2 = {99, 99, 99, 0, 2, 4, 3, 1, 99, 99, 99};
	System.out.println(quickselect(ary2, 3));
	System.out.println(quickselect(ary, 2));
    }
}
