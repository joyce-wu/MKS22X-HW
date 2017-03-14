import java.util.Random;
import java.util.Arrays;

public class partition{
    public static int[] part(int[] ary, int index){
	int[] temp = new int[ary.length];
	int num = ary[index];
	int start = 0;
	int end = ary.length-1;
	for(int i = 0; i<ary.length; i++){
	    if(i != index){
		if(ary[i] < num){
		    temp[start] = ary[i];
		    start++;
		}else{
		    temp[end] = ary[i];
		    end--;
		}
	    }
	}
	temp[start] = num;
	return temp;
			   
    }

    public static void main(String[] args){
	int[] ary = {1, 4 , 2, 10,9,44, 3};
	System.out.println(Arrays.toString(part(ary, 3)));
    }
}
