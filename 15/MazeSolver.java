import java.util.*;

public class MazeSolver{
    Maze board;
    Frontier frontier;
    boolean aStar;
    boolean animate;

    public MazeSolver(String filename){
	this(filename, false);
    }
    
    public MazeSolver(String filename, boolean anim){
	board = new Maze(filename);
	animate = anim;
    }
    
    public void solve(){
	solve(1);
    }

    public void solve(int i){
	aStar = false;
	if(i == 0){
	    frontier = new FrontierStack();
	}else if(i == 1){
	    frontier = new FrontierQueue();
	}else if(i == 2){
	    frontier = new FrontierPriorityQueue();
	}else if(i == 3){
	    frontier = new FrontierPriorityQueue();
	    aStar = true;
	}
	frontier.add(board.getStart());
	Location current;
	
	while(frontier.size() > 0){
	    current = frontier.next();
	    board.set(current.row(), current.col(), '.');
	    
	    if(distToGoal(current.row(), current.col()) == 0){
		board.set(current.row(), current.col(), 'E');
		while(current.hasPrevious()){
		    current = current.previous();
		    board.set(current.row(), current.col(), '@');
		}
		board.set(current.row(), current.col(), 'S');
		return;		
	    }
	    
	    for(Location loc: getNeighbors(current)){
		if(loc != null){
		    frontier.add(loc);
		    board.set(loc.row(), loc.col(), '?');
		}
	    }
	    
	    if(animate){
		System.out.println(board.toString(100));
	    }
	}
    }

    public ArrayList<Location> getNeighbors(Location loc){
	ArrayList<Location> ans = new ArrayList<Location>();
	int r = loc.row();
	int c = loc.col();
	
	if(r + 1 < board.getMaxRows() && board.get(r + 1, c) == ' '){
	    ans.add(new Location(r + 1, c, loc, distToStart(r+1, c),
				 distToGoal(r+1, c), aStar));
	    
	}if(r - 1 >= 0 && board.get(r - 1, c) == ' '){
	    ans.add(new Location(r - 1, c, loc, distToStart(r-1, c),
				 distToGoal(r-1, c), aStar));
	    
	}if(c + 1 < board.getMaxCols() && board.get(r, c + 1) == ' '){
	    ans.add(new Location(r, c + 1, loc, distToStart(r, c+1),
				 distToGoal(r, c+1), aStar));
	}if(c - 1 >= 0 && board.get(r, c - 1) == ' '){
	    ans.add(new Location(r, c - 1, loc, distToStart(r, c-1),
				 distToGoal(r, c-1), aStar));
	}
	return ans;
    }

    public int distToStart(int r, int c){
	return Math.abs(board.getStart().row() - r) +
	    Math.abs(board.getStart().col() - c);
    }

    public int distToGoal(int r, int c){
	return Math.abs(board.getEnd().row() - r) +
	    Math.abs(board.getEnd().col() - c);
    }

    public String toString(){
	return board.toString();
    }

    public String toString(int n){
	return board.toString(n);
    }
    
}
