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
		
		//UC 6
		game.tossToPlay();
		
		//UC 4 and 5
		int row;
		int column;
		int again;
		do {
			do {
				System.out.println("Enter the row number: ");
				row = scanner.nextInt();
				row--;
				System.out.println("Enter the column number: ");
				column = scanner.nextInt();
				column--;
			}
			while(row < 0 || row >= 3 || column < 0 || column >= 3);
		
		game.makeMove(row, column);
		game.showBoard();
		System.out.println("Do you want to play again? Enter 1.");
		again = scanner.nextInt();
		//game.computerPlays();
		}
		while(again == 1);
		
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
						System.out.println("Input entered is Invalid. Please Enter correct input");
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
	 * UC 4 and 5
	 * @return
	 */	
	public void makeMove(int row, int column) {		
		if( board[row][column] != ' ') {
			System.out.println("Cannot insert at this position as it is already filled.");
		}
		
		else {			
			board[row][column] = userInput;
			
		}		
	}
	
	/**
	 * UC 6
	 * @return
	 */	
	public void tossToPlay() {
		int  num = (int)Math.floor(Math.random() * 10) % 2;
		if(num == 0) {
			System.out.println("Computer goes first");
			//computerPlays();
		}
		
		else {
			System.out.println("User goes first");
		}
	}
	
	 
}




