public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		board[r][c] = 0;
	    }
	}
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r<board.length; r++){
	    ans += "\n";
	    for(int c = 0; c<board[0].length; c++){
		if(board[r][c] < 10){
		    ans += "_" + board[r][c] + " ";
		}else{
		    ans += "" + board[r][c] + " ";
		}
	    }
	}
	return ans;
    }

    public void solve(){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length; col++){
		if(solveH(row, col, 1)){
		    break;
		}
	    }
	}
    }

    private boolean solveH(int row, int col, int level){
	if(level > board.length * board[0].length){
	    return true;
	}if(row<board.length && row>-1 && col<board[0].length && col>-1 && board[row][col] == 0){
	    board[row][col] = level;
	    if(solveH(row+1, col+2, level+1)){
		return true;
	    }if(solveH(row+1, col-2, level+1)){
		return true;
	    }if(solveH(row-1, col+2, level+1)){
		return true;
	    }if(solveH(row-1, col-2, level+1)){
		return true;
	    }if(solveH(row+2, col+1, level+1)){
		return true;
	    }if(solveH(row+2, col-1, level+1)){
		return true;
	    }if(solveH(row-2, col+1, level+1)){
		return true;
	    }if(solveH(row-2, col-1, level+1)){
		return true;
	    }
	    board[row][col] = 0;
	}
	return false;   
    }

    public static void main(String[] args){
	KnightBoard hi = new KnightBoard(7, 8);
	hi.solve();
	System.out.println(hi);
    }
}
