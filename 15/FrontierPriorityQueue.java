import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private ArrayList<Location> heap;
    private int order;
    private int size;
    
    public FrontierPriorityQueue(){
	heap = new ArrayList<Location>();
	heap.add(new Location(-1, -1, null, -1, -1));
	size = 0;
    }

    public boolean hasNext(){
	return size > 0;
    }

    public int size(){
	return size;
    }

    public void add(Location loc){
	heap.add(loc);
	size++;
	pushUp();
	pushDown();
    }

    public Location next(){
	return remove();
    }

    public Location remove(){
	Location old = heap.set(1, heap.get(size-1));
	size--;
	pushDown();
	pushUp();
	return old;
    }

    public Location peek(){
	return heap.get(1);
    }

    private void swap(int a, int b){
	Location temp = heap.get(b);
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

}
