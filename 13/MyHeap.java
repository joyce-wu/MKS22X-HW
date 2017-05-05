import java.util.*;

public class MyHeap{

    private ArrayList<String> heap;
    private int order;
    private int size;
    
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
    }

    public MyHeap(boolean bool){
	heap = new ArrayList<String>();
	heap.add("");
	if(bool){
	    order = 1;
	}else{
	    order = -1;
	}
    }

    public void add(String s){
	heap.add(s);
	pushUp();
	size++;
    }

    public String remove(){
	String old = heap.set(1, heap.get(heap.size()-1));
	pushDown();
	size--;
	return old;
    }

    public String peek(){
	return heap.get((heap.size()-1)/2);
    }

    private void swap(int a, int b){
	String temp = heap.get(b);
	heap.set(b, heap.get(a));
	heap.set(a, temp);
    }

    private void pushUp(){
	int current = heap.size() - 1;
	while(current/2 > 0 && heap.get(current/2).compareTo(heap.get(current)) < 0){
	    swap(current, current/2);
	    current /= 2;
	}
    }

    private void pushDown(){
	int current = 1;
	while(current * 2 < heap.size() && (heap.get(current * 2).compareTo(heap.get(current)) < 0 || current * 2 + 1 < heap.size() && heap.get(current * 2 + 1).compareTo(heap.get(current)) < 0)){
	    if(heap.get(current * 2).compareTo(heap.get(current * 2 + 1)) < 0){
		swap(current, current * 2);
		current = current * 2;
	    }else{
		swap(current, current * 2 + 1);
		current = current * 2 + 1;
	    }
	}
    }

    public String toString(){
	String ans = "";
	for(int i = 1; i <= size; i++){
	    ans += heap.get(i) + " ";
	}
	return ans;
    }

    public static void main(String[] args){
	MyHeap hello = new MyHeap();
	hello.add("Hip");
	System.out.println(hello);

	hello.add("sup");
	System.out.println(hello);

	hello.add("Sup");
	//System.out.println(hello);

	hello.add("tangerines");
	hello.add("temple");
	hello.add("what");
	System.out.println(hello);
	//hello.remove();
	//hello.remove();
	//hello.remove();
	//System.out.println(hello);
    }
	    
}
