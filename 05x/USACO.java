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

	    while(inf.hasNextLine()){
		String instr = inf.nextLine();
		Scanner instrS = new Scanner(instr);
		int R_s = instrS.nextInt();
		int C_s = instrS.nextInt();
		int D_s = instrS.nextInt();
		//System.out.println(R_s + " " + C_s + " " + D_s);
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

    public int silver(String filename){
	try{
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    String header = inf.nextLine();

	    Scanner headerS = new Scanner(header);
	    int N = headerS.nextInt();
	    int M = headerS.nextInt();
	    int T = headerS.nextInt();

	    int[][] past1 = new int[N][M];
	    int[][] past2 = new int[N][M];
	    for(int r = 0; r < N; r++){
		String row = inf.nextLine();
		for(int c = 0; c < M; c++){
		    String charac = row.substring(c, c+1);
		    if(charac.equals("*")){
			past1[r][c] = -1;
			past2[r][c] = -1;
		    }if(charac.equals(".")){
			past1[r][c] = 0;
			past2[r][c] = 0;
		    }
		}
	    }

	    String info = inf.nextLine();
	    Scanner infoS = new Scanner(info);
	    int R1 = infoS.nextInt()-1;
	    int C1 = infoS.nextInt()-1;
	    int R2 = infoS.nextInt()-1;
	    int C2 = infoS.nextInt()-1;

	    for(int time = 0; time <= T; time++){
		if(time == 0){
		    past2[R1][C1] = 1;
		}else if(time%2 != 0){
		    for(int r = 0; r < N; r++){
			for(int c = 0; c < M; c++){
			    if(past2[r][c] != 0 && past2[r][c] != -1){
				past1[r][c] = 0;
			    }if(past1[r][c] != -1){
				past1[r][c] = findMoves(r, c, past2);
			    }
			}
		    }
		}else{
		    for(int r = 0; r < N; r++){
			for(int c = 0; c < M; c++){
			    if(past1[r][c] != 0 && past2[r][c] != -1){
				past2[r][c] = 0;
			    }if(past2[r][c] != -1){
				past2[r][c] = findMoves(r, c, past1);
			    }
			}
		    }
		}
	    }
	    if(T%2 == 0){
		return past2[R2][C2];
	    }else{
		return past1[R2][C2];
	    }
		
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return -1;
    }

    public int findMoves(int r, int c, int[][] pasture){
	int total = 0;
	if(r > 0 && pasture[r-1][c] != -1){ 
	    total += pasture[r-1][c];
	}if(r < pasture.length-1 && pasture[r+1][c] != -1){
	    total += pasture[r+1][c];
	}if(c > 0 && pasture[r][c-1] != -1){
	    total += pasture[r][c-1];
	}if(c < pasture[0].length-1 && pasture[r][c+1] != -1){
	    total += pasture[r][c+1];
	}
	return total;
    }
		    

    public static void main(String[] args){
	USACO bloop = new USACO();
	// System.out.println(bloop.bronze("infile1.txt")); //342144
	// System.out.println(bloop.bronze("makelake.2.in")); //102762432
	// System.out.println(bloop.bronze("makelake.3.in")); //1058992704
	// System.out.println(bloop.bronze("makelake.4.in")); //753121152
	// System.out.println(bloop.bronze("makelake.5.in")); //1028282688
	// System.out.println(bloop.bronze("makelake.6.in")); //72207936
	// System.out.println(bloop.bronze("makelake.7.in")); //265508928
	// System.out.println(bloop.bronze("makelake.8.in")); //776609856
	// System.out.println(bloop.bronze("makelake.9.in")); //2098830528
	// System.out.println(bloop.bronze("makelake.10.in")); //211201344

	// System.out.println(bloop.silver("ctravel.1.in"));//1
	// System.out.println(bloop.silver("ctravel.2.in"));//74
	// System.out.println(bloop.silver("ctravel.3.in"));//6435
	// System.out.println(bloop.silver("ctravel.4.in"));//339246
	// System.out.println(bloop.silver("ctravel.5.in"));//0
	// System.out.println(bloop.silver("ctravel.6.in"));//14396412
	// System.out.println(bloop.silver("ctravel.7.in"));//1533810
	// System.out.println(bloop.silver("ctravel.8.in"));//456055
	// System.out.println(bloop.silver("ctravel.9.in"));//28
	// System.out.println(bloop.silver("ctravel.10.in"));//1321670

    }

    
}
