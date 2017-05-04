import java.util.*;

public class MyHeap{

    private ArrayList<String> heap;
    private int order;
    
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
	heap.set(heap.size(), s);
	pushUp();
    }

    public String remove(){
	String old = heap.set(1, heap.get(heap.size()-1));
	pushDown();
	return old;
    }

    public String peek(){
	return heap.get((heap.size()-1)/2);
    }

    private void swap(int a, int b){
	String temp = heap.set(a, heap.get(b));
	heap.set(b, temp);
    }

    private void pushUp(){
	int current = heap.size() - 1;
	while(current > 0 && heap.get(current/2).compareTo(heap.get(current)) > 0){
	    swap(current, current/2);
	    current /= 2;
	}
    }

    private void pushDown(){
	int current = 1;
	while(current < heap.size() && (heap.get(current * 2).compareTo(heap.get(current)) < 0 || heap.get(current * 2 + 1).compareTo(heap.get(current)) < 0)){
	    if(heap.get(current * 2).compareTo(heap.get(current * 2 + 1)) < 0){
		swap(current, current * 2);
		current = current * 2;
	    }else{
		swap(current, current * 2 + 1);
		current = current * 2 + 1;
	    }
	}
    }
	    
}
