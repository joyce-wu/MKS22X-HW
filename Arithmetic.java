import java.util.*;

public class Arithmetic{
    public static double eval(String string){
	String[] tokens = string.split(" ");
	Stack<Double> s = new Stack<Double>();
	for(String token : tokens){
	    if(isOp(token)){
		s.push(apply(token, s.pop(), s.pop()));
	    }else{
		s.push(Double.parseDouble(token));
	    }
	}
	return s.pop();
    }

    private static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("/") ||
	    s.equals("%") || s.equals("*");
    }

    private static double apply(String op, double a, double b){
	if(op.equals("*")){
	    return a * b;
	}if(op.equals("-")){
	    return a - b;
	}if(op.equals("+")){
	    return a + b;
	}if(op.equals("%")){
	    return a % b;
	}if(op.equals("+")){
	    return a + b;
	}
	return -1;
    }
}
