import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private ArrayList<Location> heap;
    
    public FrontierPriorityQueue(){
	heap = new ArrayList<Location>();
	heap.add(null);
    }

    public boolean hasNext(){
	return heap.size() > 0;
    }

    public int size(){
	return heap.size();
    }

    public void add(Location loc){
	heap.add(loc);
	pushUp();
    }

    public Location next(){
	return remove();
    }

    public Location remove(){
	Location old;
	old = heap.set(1, heap.get(heap.size()-1));
	heap.remove(size()-1);
	pushDown();
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
	int current = size()-1;
	while(current > 1 && heap.get(current).compareTo(heap.get(current/2)) > 0){
	    swap(current, current/2);
	    current /= 2;
	}
    }

    private void pushDown(){
	int current = 1;
	if(size()-1 == 2 && heap.get(1).compareTo(heap.get(2)) < 0){
	    swap(1, 2);
	    return;
	}
	while(current * 2 + 1 < size()){
	    if(heap.get(current*2).compareTo(heap.get(current*2+1)) > 0){
		if(heap.get(current).compareTo(heap.get(current*2)) < 0){
		    swap(current, current*2);
		    current = current * 2;
		}else if(heap.get(current).compareTo(heap.get(current*2+1)) < 0)
		    {
			swap(current, current*2+1);
			current = current*2+1;
		    }else{
		    return;
		}
	    }else{
		if(heap.get(current).compareTo(heap.get(current*2+1)) < 0){
		    swap(current, current*2+1);
		    current = current*2+1;
		}else if(heap.get(current).compareTo(heap.get(current*2)) < 0){
		    swap(current, current*2);
		    current = current * 2;
		}else{
		    return;
		}
	    }
	}
    }

    public String toString(){
	String str = "[";
	if(size() > 0){
	    for(Location loc:heap){
		str += loc.row() + " " + loc.col() + ", ";
	    }
	}
	return str + "]";
    }
}


  
