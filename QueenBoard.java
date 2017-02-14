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
	solutionCount = 0;
    }

    public boolean solve(){
	return solveH(0);
    }
    
    private void addQueen(int r, int c){
	board[r][c] = -1;
	int length = board.length;
       	for(int row = r+1; row < length; row++){
	    board[row][c] += 1;
	}for(int rows = r-1; rows > -1; rows--){
	    if(board[rows][c] != -1)
		board[rows][c] += 1;
	}for(int cols = c-1; cols > -1; cols--){
	    if(board[r][cols] != -1)
		board[r][cols] += 1;
	}for(int col = c+1; col < length; col++){
	    board[r][col] += 1;
	}for(int n = 1; r-n > -1 && c-n > -1; n++){
	    if(board[r-n][c-n] != -1)
		board[r-n][c-n] += 1;
	}for(int i = 1; r+i < length && c+i < length; i++){
	    board[r+i][c+i] += 1;
	}for(int p = 1; r+p < length && c-p > -1; p++){
	    board[r+p][c-p] += 1;
	}for(int j = 1; r-j > -1 && c+j < length; j++){
	    if(board[r-j][c+j] != -1)
		board[r-j][c+j] += 1;
	}
    }

    private  void removeQueen(int r, int c){
	board[r][c] = 0;
	int length = board.length;
	for(int row = r+1; row < length; row++){
	    board[row][c] -= 1;
	}for(int rows = r-1; rows > -1; rows--){
	    if(board[rows][c] != -1)
		board[rows][c] -= 1;
	}for(int cols = c-1; cols > -1; cols--){
	    if(board[r][cols] != -1)
		board[r][cols] -= 1;
	}for(int col = c+1; col < length; col++){
	    board[r][col] -= 1;
	}for(int n = 1; r-n > -1 && c-n > -1; n++){
	    if(board[r-n][c-n] != -1)
		board[r-n][c-n] -= 1;
	}for(int i = 1; r+i < length && c+i < length; i++){
	    board[r+i][c+i] -= 1;
	}for(int p = 1; r+p < length && c-p > -1; p++){
	    board[r+p][c-p] -= 1;
	}for(int j = 1; r-j > -1 && c+j < length; j++){
	    if(board[r-j][c+j] != -1)
		board[r-j][c+j] -= 1;
	}
    }

    private boolean solveH(int c){
	if(c >= board.length){
	    return true;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][c] == 0){
		addQueen(r, c);
      		if(!solveH(c + 1)){
		    removeQueen(r, c);
		}else
		    return true;
	    }
	}
	return false;
    }
	
	
    public int getSolutionCount(){	
	if(board.length == 1){
	    return 1; }
	if(board.length == 2 || board.length == 3){
	    return 0; }
	countH(0);
	return solutionCount;
    }

    public void countH(int c){
	if(c >= board.length){
	    solutionCount++;
	    return;
	}
	for(int r = 0; r < board.length; r++){
	    if(board[r][c] == 0){
		addQueen(r, c);
		countH(c+1);
		removeQueen(r, c);
	    }
	}
    }
	

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    ans += "\n";
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == -1){
		    ans += "Q ";}
		else{
		    ans += "_ ";}
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(10);
	//test.solve();
	//System.out.println(test);
	System.out.println(test.getSolutionCount());
    }
}
