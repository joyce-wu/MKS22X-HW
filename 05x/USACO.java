import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){
    }
    
    public int bronze(String filename){
	try{
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    String header = inf.nextLine();

	    Scanner facs = new Scanner(header);
	    int R = facs.nextInt();
	    int C = facs.nextInt();
	    int E = facs.nextInt();
	    int N = facs.nextInt();

	    int[][] lake = new int[R][C];
	    for(int r = 0; r<R; r++){
		String elavs = inf.nextLine();
		Scanner elavsS = new Scanner(elavs);
		for(int c = 0; c<C; c++){
		    lake[r][c] = elavsS.nextInt();
		}
	    }

	    //toString
	    print(R, C, E, N, lake);
	    
	    while(inf.hasNextLine()){
		String instr = inf.nextLine();
		Scanner instrS = new Scanner(instr);
		int R_s = instrS.nextInt();
		int C_s = instrS.nextInt();
		int D_s = instrS.nextInt();
		System.out.println(R_s + " " + C_s + " " + D_s);
		int highest = lake[R_s-1][C_s-1];
		for(int row = R_s-1; row<R_s+2; row++){
		    for(int col = C_s-1; col<C_s+2; col++){
			if(lake[row][col] > highest){
			    highest = lake[row][col];
			}
		    }
		}
		int supposedEl = highest - D_s;
		for(int row = R_s-1; row<R_s+2; row++){
		    for(int col = C_s-1; col<C_s+2; col++){
			if(lake[row][col] > supposedEl){
			    lake[row][col] = supposedEl;
			}
		    }
		}
		print(R, C, E, N, lake);
	    }

	    int totalDepth = 0;
	    for(int r = 0; r<R; r++){
		for(int c = 0; c<C; c++){
		    if(lake[r][c] < E){
			totalDepth += E - lake[r][c];
		    }
		}
	    }
	    return totalDepth * 72 * 72;

	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return -1;
    }

    public void print(int R, int C, int E, int N, int[][] lake){
	System.out.println(R + " " + C + " " + E + " " + N + "\n");
	for(int rR = 0; rR<lake.length; rR++){
	    for(int cC = 0; cC<lake[0].length; cC++){
		System.out.print(lake[rR][cC] + " ");
	    }
	    System.out.println("");
	}
    }
	
	
    public int silver(String filename){
	return -1;
    }

    public static void main(String[] args){
	USACO bloop = new USACO();
	System.out.println(bloop.bronze("infile1.txt")); //342144
    }

    
}
