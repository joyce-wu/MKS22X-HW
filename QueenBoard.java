public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		board[r][c] = 0;
	    }
	}
    }

    public boolean solve(){
	return solveH(0);
    }
    
    private void addQueen(int r, int c){
	board[r][c] = -1;
	int length = board.length;
       	for(int row = r+1; row < board.length; row++){
	    board[row][c] += 1;
	}for(int rows = r-1; rows > -1; rows--){
	    if(board[rows][c] != -1)
		board[rows][c] += 1;
	}for(int cols = c-1; cols > -1; cols--){
	    if(board[r][cols] != -1)
		board[r][cols] += 1;
	}for(int col = c+1; col < board.length; col++){
	    board[r][col] += 1;
	}for(int n = 1; r-n > -1 && c-n > -1; n++){
	    if(board[r-n][c-n] != -1)
		board[r-n][c-n] += 1;
	}for(int i = 1; r+i < length && c+i < length; i++){
	    System.out.println((r+i) + " " + (c+i));
	    board[r+i][c+i] += 1;
	}for(int p = 1; r+p > length && c-p > -1; p++){
	    System.out.println((r+p) + " " +  (c-p));
	    board[r+p][c-p] += 1;
	}for(int j = 1; r-j > -1 && c+j > length; j++){
	    if(board[r-j][c+j] != -1)
		board[r-j][c+j] += 1;
	}
    }

    private  void removeQueen(int c){
	if(c != 0){
	    c -= 1;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][c] == -1){
		board[r][c] = 0;
		for(int row = r+1; row < board.length; row++){
		    board[row][c] -= 1;
		}for(int col = c+1; col < board.length; col++){
		    board[r][col] -= 1;
		}for(int i = 1; r+i < board.length && c+i < board.length; i++){
		    board[r+i][c+i] -= 1;
		}
	    }
	}
	System.out.println(toString());
    }

    private boolean solveH(int c){
	if(c >= board.length){
	    for(int r = 0; r < board.length; r++){
		if(board[r][board.length-1] == -1)
		    return true;
      	    }
	    return false;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][c] == 0){
		addQueen(r, c);
		System.out.println(toString());
      		solveH(c + 1);
	    }else if(r == board.length-1){ 
		removeQueen(c);
		System.out.println(toString());
	    }
	}
	return false;    
    }
	
	
    public int getSolutionCount(){	
	return -1;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    //if(r != 0){
		ans += "\n";
		//	    }
	    for(int c = 0; c < board[0].length; c++){
		ans += board[r][c];
		ans += " ";
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(4);
	test.solve();
	System.out.println(test);
    }
}
