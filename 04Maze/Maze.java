import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    public void setAnimate(boolean b){
    }
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    public boolean solve(){
	int startr = -1, startc = -1;
	maze[startr][startc] = ' ';
	return solve(startc, startc);
    }
    public boolean solve(int row, int col){
	if(animate){
	    System.our.println("\033[2J\033[1;1H" + this);
	    wait(20);
	}
	return false;
    }
}

