import java.util.*;

public class MazeSolver{
    Maze board;
    Frontier frontier;

    public MazeSolver(String filename){
	board = new Maze(filename);
    }
    
    public void solve(){
	solve(1);
    }

    public void solve(int i){
	if(i == 0){
	    FrontierStack frontier = new FrontierStack();
	}else if(i == 1){
	    FrontierQueue frontier = new FrontierQueue();
	}else if(i == 2){
	    FrontierPriorityQueue frontier = new FrontierPriorityQueue();
	}else if(i == 3){
	    FrontierPriorityQueue frontier = new FrontierPriorityQueue();
	    board.getStart().setAStar(true);
	}
	
	frontier.add(board.getStart());
	
	while(frontier.hasNext()){
	    Location current = frontier.next();
	    
	    if(distToGoal(current) == 0){
		while(current.hasPrevious()){
		    board.set(current.row(), current.col(), '@');
		    current = current.previous();
		}
		board.set(board.getStart().row(), board.getStart().col(), '@');
		board.set(board.getEnd().row(), board.getEnd().col(), '@');
		break;
	    }
	    
	    board.set(current.row(), current.col(), '.');
	    for(int n = 1; n <= 4; n++){
		int r = rowCheck(current, n);
		int c = colCheck(current, n);
		if(isValid(r, c)){
		    frontier.add(new Location(r, c, current, distToStart(current), distToGoal(current)));
		    board.set(r, c, '?');
		}
	    }
	}
    }

    private boolean isValid(int r, int c){
	return r > 0 && r < board.getMaxRows() && c > 0 && c < board.getMaxCols() && board.get(r, c) == ' ';
    }
    
    private int rowCheck(Location loc, int i){
	if(i == 0){
	    return loc.row() + 1;
	}if (i == 0){
	    return loc.row() - 1;
	}
	return loc.row();
    }

    private int colCheck(Location loc, int i){
	if(i == 3){
	    return loc.col() + 1;
	}if(i == 4){
	    return loc.col() - 1;
	}
	return loc.col();
    }
	
    private int distToStart(Location loc){
	return Math.abs(board.getStart().row() - loc.row()) +
	    Math.abs(board.getStart().col() - loc.col());
    }
    
    private int distToGoal(Location loc){
	return Math.abs(board.getEnd().row() - loc.row()) +
	    Math.abs(board.getEnd().col() - loc.col());
    }

    public String toString(){
	return board.toString();
    } 
    
}
