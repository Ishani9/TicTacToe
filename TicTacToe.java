package Assignment;

public class TicTacToe {
	public char[][] board;
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.createBoard();
	}
	
	public void createBoard(){
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	 
}




