import java.util.*;

public class FrontierQueue implements Frontier{
    private LinkedList<Location> front;
    private int size;

    public FrontierQueue(){
	front = new LinkedList<Location>();
    }

    public void add(Location loc){
	front.add(loc);
    }

    public Location next(){
	return front.remove();
    }

    public boolean hasNext(){
	return front.size() > 0;
    }

    public int size(){
	return front.size();
    }
}
