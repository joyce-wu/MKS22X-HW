import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private boolean e = false, s = false;
    public Maze(String filename){
	readFile(filename);
	animate = false;
    }
    
    public void readFile(String filename){
	try{
	    //create maze
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    int lines = 0;
	    int cols = 0;
	    while(inf.hasNextLine()){
		lines++;
		cols = inf.nextLine().length();
	    }
	    maze = new char[lines][cols];

	    //add chars to maze
	    Scanner inf1 = new Scanner(text);
	    int line = 0;
	    while(inf1.hasNextLine()){
		String lineChar = inf1.nextLine();
		for(int i = 0; i<lineChar.length(); i++){
		    if(lineChar.charAt(i) == 'E'){
			e = true;
		    }if(lineChar.charAt(i) == 'S'){
			s = true;
		    }
		    maze[line][i] = lineChar.charAt(i);
		}
		line++;
	    }
	    
	    if(e == false || s == false){
		System.out.println("No S or E");
		System.exit(0);
	    }		    
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
    }
	    
    public void setAnimate(boolean b){
	animate = b;
    }
    
    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }
    
    public boolean solve(){
	int startr = -1, startc = -1;
	for(int r = 0; r<maze.length; r++){
	    for(int c = 0; c<maze[0].length; c++){
		if(maze[r][c] == 'S'){
		    startr = r;
		    startc = c;
		}
	    }
	}
	maze[startr][startc] = ' ';
	return solve(startr, startc);
    }
    
    public boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H" + this);
	    wait(20);
	}
	if(maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if(solve(row+1, col)){
		return true;
	    }else if(solve(row-1, col)){
		return true;
	    }else if(solve(row,col+1)){
		return true;
	    }else if(solve(row,col-1)){
		return true;
	    }
	    maze[row][col] = '.';
	}
	return false;
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}catch(InterruptedException e){
	}
    }

    public String toString(){
	String ans = "";
	for(int r=0; r<maze.length; r++){
	    for(int c=0; c<maze[0].length; c++){
		ans += maze[r][c];
	    }
	    ans += "\n";
	}
	return ans;
    }
				   
}

