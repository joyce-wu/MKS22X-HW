public class Recursion{
    public static String name(){
	return "Wu,Joyce";
    }
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}if(n==0){
	    return 0;
	}else{
	    return better(n, 1.0);
	}
    }
    private static double better(double n, double guess){
	if(Math.abs((n - guess*guess)/n) < 0.000000001){
	    return guess;
	}
	double guessNum = (n/guess + guess) / 2;
	return better(n , guessNum);
    }
    public static void main(String[] args){
	System.out.println(sqrt(100)); //10
	System.out.println(sqrt(4)); //2
	System.out.println(sqrt(200)); //14.14
	System.out.println(sqrt(12345)); //111.11
	System.out.println(sqrt(-100)); //exception
    }
}
