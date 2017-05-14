import java.util.*;

public class MyHeap{
    private ArrayList<Integer> heap;
    private int order;
    private int size;
    
    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(0);
	order = 1;
    }

    public MyHeap(boolean bool){
	heap = new ArrayList<Integer>();
	heap.add(0);
	if(bool){
	    order = 1;
	}else{
	    order = -1;
	}
    }

    public void add(int s){
	//System.out.println(s);
	heap.add(s);
	size++;
	//System.out.println("add: " + toString());
	pushUp();
	pushDown();
	//System.out.println("add pushUp: " + toString());
    }

    public int remove(){
	int old = heap.set(1, heap.remove(size));
	size--;
	//System.out.println(toString());
	pushDown();
	pushUp();
	return old;
    }

    public int peek(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
	return heap.get(1);
    }

    private void swap(int a, int b){
	int temp = heap.get(b);
	heap.set(b, heap.get(a));
	heap.set(a, temp);
    }

    private void pushUp(){
	int current = size;
	while(current > 1 && heap.get(current/2).compareTo(heap.get(current))*order < 0){
	    //System.out.println("current: " + current);
	    //System.out.println("push up" + toString());
	    swap(current, current/2);
	    //System.out.println("push up after swap" + toString());
	    current = current/ 2;
	}
    }

    private void pushDown(){
	int current = 1;
	if(size == 2 && heap.get(1).compareTo(heap.get(2)) * order < 0){
	    swap(1, 2);
	    return;
	}
	while(current * 2 + 1 <= size){
	    if(heap.get(current*2).compareTo(heap.get(current*2+1))*order > 0){
		if(heap.get(current).compareTo(heap.get(current*2))*order < 0){
		    swap(current, current*2);
		    current = current * 2;
		}else if(heap.get(current).compareTo(heap.get(current*2+1)) * order < 0){
		    swap(current, current*2+1);
		    current = current*2+1;
		}else{
		    return;
		}
	    }else{
		if(heap.get(current).compareTo(heap.get(current*2+1)) * order < 0){
		    swap(current, current*2+1);
		    current = current*2+1;
		}else if(heap.get(current).compareTo(heap.get(current*2)) * order < 0){
		    swap(current, current*2);
		    current = current * 2;
		}else{
		    return;
		}
	    }
	}
    }
	
	/**
	while(current * 2 <= size){
	    //System.out.println("push down: " + toString());
	    if(current == size/2 && size%2 == 0){
		if(heap.get(current*2) > order*heap.get(current)){
		    swap(current, current * 2);
		    current = current * 2;
		}
	    }else if(heap.get(current*2) > order*heap.get(current) ||
		     (current*2+1 < size &&
		      heap.get(current*2+1) > order*heap.get(current))){	    
		if(heap.get(current*2) > order * heap.get(current*2+1)){
		    swap(current, current * 2);
		    current = current * 2;
		}else{
		    swap(current, current * 2 + 1);
		    current = current * 2 + 1;
		}
	    }else{
		break;
	    }
	}
    }
	**/
   
    public int size(){
	return size;
    }
    
    public String toString(){
	String ans = "";
	for(int i = 1; i <= size; i++){
	    ans += "(" + i + ")" + heap.get(i) + " ";
	}
	return ans;
    }
}
