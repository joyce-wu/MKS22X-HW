public class Recursion{
    public static String name(){
	return "Wu,Joyce";
    }
    public static double sqrt(double n){
	double guess = better(n, 0);
	if(Math.abs(n-guess)/n < 0.0000000001){
	    return guess;
	}
	return better(n, guess);
    }
    private static double better(double n, double guess){
	return (n/guess + guess) / 2;
    }
    public static void main(String[] args){
	System.out.println(sqrt(100)); //10
	System.out.println(sqrt(4)); //2
	System.out.println(sqrt(200)); //14.14
	System.out.println(sqrt(12345)); //111.11
    }
}
