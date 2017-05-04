import java.util.*;

public class StackCalc{
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
    
	for(String token : tokens){
	    if(isOp(token)){
		values.push(apply(token,values.pop(),values.pop()));
	    }
	    else{
		values.push(Double.parseDouble(token));
	    }
	}
    
	return values.pop();
    }
    private static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("/") ||
	    s.equals("%") || s.equals("*");
    }

    private static double apply(String op, double a, double b){
	if(op.equals("*")){
	    return b * a;
	}if(op.equals("-")){
	    return b - a;
	}if(op.equals("+")){
	    return b + a;
	}if(op.equals("%")){
	    return b % a;
	}if(op.equals("/")){
	    return b / a;
	}
	return -1;
    }

    public static void main(String[] args)
    {
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }

}
