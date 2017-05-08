import java.util.*;

public class MyHeap{
    private ArrayList<Integer> heap;
    private int order;
    private int size;
    
    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(0);
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
	heap.add(s);
	pushUp();
	size++;
    }

    public int remove(){
	int old = heap.set(1, heap.get(heap.size()-1));
	pushDown();
	size--;
	return old;
    }

    public int peek(){
	return heap.get((heap.size()-1)/2);
    }

    private void swap(int a, int b){
	int temp = heap.get(b);
	heap.set(b, heap.get(a));
	heap.set(a, temp);
    }

    private void pushUp(){
	int current = heap.size() - 1;
	while(current/2 > 0 && order * heap.get(current/2) < heap.get(current)){
	    swap(current, current/2);
	    current /= 2;
	}
    }

    private void pushDown(){
	int current = 1;
	while(current * 2 < heap.size() && order * heap.get(current * 2) > heap.get(current) || order * current * 2 + 1 < heap.size() && order * heap.get(current*2+1) > heap.get(current)){
	    if(order * heap.get(current * 2) > heap.get(current * 2 + 1)){
		swap(current, current * 2);
		current = current * 2;
	    }else{
		swap(current, current * 2 + 1);
		current = current * 2 + 1;
	    }
	}
    }

    public int size(){
	return heap.size();
    }

    public int get(int i){
	return heap.get(i);
    }
    
    public String toString(){
	String ans = "";
	for(int i = 1; i <= size; i++){
	    ans += heap.get(i) + " ";
	}
	return ans;
    }
}
