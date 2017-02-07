public class Recursion{
    public static String name(){
	return "Wu,Joyce";
    }
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}else{
	    return better(n, 1.0);
	}
    }
    private static double better(double n, double guess){
	double guessNum = (n/guess + guess) / 2;
	if(Math.abs(n - guessNum*guessNum)/n < 0.000000001){
	    return guessNum;
	}
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
