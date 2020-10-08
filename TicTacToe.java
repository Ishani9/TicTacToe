package Assignment;
import java.util.Scanner;

public class TicTacToe {
	public char[][] board;
	char computerInput = ' ';
	static char userInput = ' ';
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TicTacToe game = new TicTacToe();
		
		game.createBoard();
		
		//UC 2
		System.out.println("Player 1: Choose X or O");
		userInput = scanner.next().charAt(0);	
		game.chooseLetter(userInput);
		
		//UC 4
		int row;
		int column;
		System.out.println("Enter the row number: ");
		row = scanner.nextInt();
		row--;
		System.out.println("Enter the column number: ");
		column = scanner.nextInt();
		column--;
		game.makeMove(row, column);
		
		//UC 3
		game.showBoard();
		
		
		scanner.close();
	}
	
	/**
	 * UC 1
	 * @return
	 */	
	public void createBoard(){
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	/**
	 * UC 2
	 * @return
	 */	
	
	public void chooseLetter(int userInput) {
		do {
				switch(userInput) {
					case 'X':
						computerInput = 'O';
						break;
						
					case 'O':
						computerInput = 'X';
						break;
						
					default:
						System.out.println("Enter correct input");
						break;
				}
		}
		while (userInput !='X'&& userInput !='O');
	}
	
	
	/**
	 * UC 3
	 * @return
	 */	
	public void showBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("------------ ");
		}
	}
	
	/**
	 * UC 4
	 * @return
	 */	
	public void makeMove(int row, int column) {		
		if( board[row][column] != ' ') {
			System.out.println("Cannot insert at this position");
		}
		
		else {			
			board[row][column] = userInput;
		}		
	}
	
	
	 
}




