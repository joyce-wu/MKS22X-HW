import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){
	int[] temp = new int[data.length];
	Random rand = new Random();
	int randI = (rand.nextInt(end-start)+1)+start;
	System.out.println(randI);
	int num = data[randI];
	System.out.println(num);
	int s = start;
	int e = end;
	for(int i = 0; i < temp.length; i++){
	    if(i != randI){
		if(i < start || i > end){
		    temp[i] = data[i];
		}else{
		    if(data[i] > num){
			temp[e] = data[i];
			e--;
		    }else{
			temp[s] = data[i];
			s++;
		    }
		}
		System.out.println(Arrays.toString(temp));

	    }
	}
	temp[s] = num;
	System.out.println(Arrays.toString(temp));
	return s;
    }

    public static void main(String[] args){
	int[] ary = {4, 3, 5, 77, 100, 2, 41, 32, 45, 21, 11};
	System.out.println(part(ary, 0, 5));
    }
}
