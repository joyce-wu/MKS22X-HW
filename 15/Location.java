public class Location implements Comparable<Location>{
    private int row, col;
    private Location previous;
    private int distToStart, distToGoal;
    private boolean aStar;

    public Location(int r, int c, Location prev, int start, int goal){
	row = r;
	col = c;
	previous = prev;
	distToStart = start;
	distToGoal = goal;
	aStar = true;
    }

    public Location(int r, int c, Location prev, int start, int goal, boolean a)
    {
	row = r;
	col = c;
	previous = prev;
	distToStart = start;
	distToGoal = goal;
	aStar = a;
    }

    public int compareTo(Location other){
	if(aStar){
	    return (distToStart+distToGoal) - (other.distToStart() + other.distToGoal());
	}
	return distToGoal - other.distToGoal();
    }

    public int distToStart(){
	return distToStart;
    }

    public int distToGoal(){
	return distToGoal;
    }

    public void setAStar(boolean b){
	aStar = b;
    }

    public int row(){
	return row;
    }

    public int col(){
	return col;
    }

    public Location previous(){
	return previous;
    }

    public boolean hasPrevious(){
	return previous != null;
    }
}
