public class RunningMedian{
    MyHeap lessThan, moreThan;
    double median;

    public RunningMedian(){
	lessThan = new MyHeap(true);
	moreThan = new MyHeap(false);
    }

    public double getMedian(){
	return lessThan.peek() + moreThan.peek() / 2.0;
    }
    
    public void add(int n){
	if(lessThan.size() == 0 && moreThan.size() == 0){
	    lessThan.add(n);
	}else if(n < median){
	    lessThan.add(n);
	}else{
	    moreThan.add(n);
	}
	if(lessThan.size() - moreThan.size() >= 2){
	    moreThan.add(lessThan.remove());
	}else if(lessThan.size() - moreThan.size() >= -2){
	    lessThan.add(moreThan.remove());
	}
    }

    public static void main(String[] args){
	/**
	MyHeap hello = new MyHeap();
	for(int i = 1; i < 11; i += 2){
	    hello.add(i);
	}
	for(int i = 0; i < 6; i++){
	    hello.remove(i);
	    System.out.println(hello);
	}
	System.out.println(hello);
	    public static void main(String[]args){
	**/
	/**
	MyHeap a = new MyHeap();
	a.add("5");
	a.add("4");
	a.add("3");
	a.add("2");
	a.add("1");
	System.out.println(a);
       	String test1 = a.peek();
       	System.out.println(test1);
	System.out.println(a.remove());
	System.out.println(a);
       	String test = a.peek();
       	System.out.println(test);
	**/
       	MyHeap b = new MyHeap(true);
	b.add(21);
	b.add(16);
	b.add(20);
	b.add(5);
	b.add(18);
	b.add(12);
	b.add(19);
	System.out.println(b);
       	//Integer testb1 = b.peek();
       	//System.out.println(testb1);
	/**b.remove();
	System.out.println(b);
        b.remove();
	System.out.println(b);
        b.remove();
	System.out.println(b);
	b.remove();
	System.out.println(b);
       	Integer testb = b.peek();
       	System.out.println(testb);
	**/
    }

}
