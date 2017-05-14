import java.util.*;

public class MyHeap{

    private ArrayList<String> heap;
    private int order;
    private int size;
    
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
    }

    public MyHeap(boolean bool){
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
	if(bool){
	    order = 1;
	}else{
	    order = -1;
	}
    }

    public int size(){
	return size;
    }

    public void add(String s){
	heap.add(s);
	size++;
	pushUp();
	pushDown();
    }

    public String remove(){
	String old = heap.set(1, heap.get(size-1));
	size--;
	pushDown();
	pushUp();
	return old;
    }

    public String peek(){
	return heap.get(1);
    }

    private void swap(int a, int b){
	String temp = heap.get(b);
	heap.set(b, heap.get(a));
	heap.set(a, temp);
    }

    private void pushUp(){
	int current = size;
	while(current > 1 && order * heap.get(current/2).compareTo(heap.get(current)) > 0){
	    swap(current, current/2);
	    current /= 2;
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
