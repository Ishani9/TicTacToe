package Assignment;

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
	public char[][] board;
	char computerInput = ' ';
	static char userInput = ' ';

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		TicTacToe game = new TicTacToe();

		game.createBoard();

		// UC 2
		System.out.println("Player 1: Choose X or O");
		userInput = scanner.next().charAt(0);
		game.chooseLetter(userInput);

		// UC 6
		game.tossToPlay();

		// UC 4 and 5
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
			} while (row < 0 || row >= 3 || column < 0 || column >= 3);

			game.makeMove(row, column);
			game.showBoard();
			System.out.println("Do you want to play again? Enter 1.");
			again = scanner.nextInt();
			game.computerPlays();
			game.resultsForGame();
			
		} while (again == 1);

		// UC 3
		game.showBoard();

		scanner.close();
	}

	/**
	 * UC 1
	 * 
	 * @return
	 */
	public void createBoard() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * UC 2
	 * 
	 * @return
	 */

	public void chooseLetter(int userInput) {
		do {
			switch (userInput) {
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
		} while (userInput != 'X' && userInput != 'O');
	}

	/**
	 * UC 3
	 * 
	 * @return
	 */
	public void showBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("------------ ");
		}
		
	}

	/**
	 * UC 4 and 5
	 * 
	 * @return
	 */
	public void makeMove(int row, int column) {
		if (board[row][column] != ' ') {
			System.out.println("Cannot insert at this position as it is already filled.");
		}

		else {
			board[row][column] = userInput;

		}
	}

	/**
	 * UC 6
	 * 
	 * @return
	 */
	public void tossToPlay() {
		int num = (int) Math.floor(Math.random() * 10) % 2;
		if (num == 0) {
			System.out.println("Computer goes first");
			computerPlays();
		}

		else {
			System.out.println("User goes first");
		}
	}

	public void computerPlays() {
		int row ;
		int column ;
		int[] array = new int[2];
		array = checkForWin();
		row = array[0];
		column = array[1];
		if(row== 0 && column ==0) {
			row = (int) Math.floor(Math.random() * 10) % 3;
			column = (int) Math.floor(Math.random() * 10) % 3;
		}
		if (board[row][column] == ' ') {
			board[row][column] = computerInput;
			showBoard();
		} 
		if (board[row][column] != ' ') {
			computerPlays();
		}
	}
	
	
	
	/**
	 * UC 8
	 * 
	 * @return
	 */
	public int[] checkForWin() {
		int[] array = new int[2];
		int row = 0;
		int column = 0;
		for (int i = 0; i < 3; i++) {
			if (compare(board[i][0], board[i][1]) == 0) {
				if (compare(board[i][0], computerInput) == 0) {
					row = i;
					column = 2;
				}
			}
			if (compare(board[i][2], board[i][1]) == 0) {
				if (compare(board[i][2], computerInput) == 0) {
					row = i;
					column = 0;
				}
			}
			if (compare(board[i][2], board[i][0]) == 0) {
				if (compare(board[i][2], computerInput) == 0) {
					row = i;
					column = 1;
				}
			}
			
			//columns
			if (compare(board[0][i], board[1][i]) == 0) {
				if (compare(board[0][i], computerInput) == 0) {
					row = 2;
					column = i;
				}
			}
			if (compare(board[0][i], board[2][i]) == 0) {
				if (compare(board[0][i], computerInput) == 0) {
					row = 1;
					column = i;
				}
			}
			if (compare(board[2][i], board[1][i]) == 0) {
				if (compare(board[0][i], computerInput) == 0) {
					row = 0;
					column = i;
				}
			}
		}
		
		
		
		//Diagonals
		if (compare(board[1][1], board[2][2]) == 0) {
			if (compare(board[1][1], computerInput) == 0) {
				row = 0;
				column = 0;
			}
		}
		if (compare(board[1][1], board[0][0]) == 0) {
			if (compare(board[1][1], computerInput) == 0) {
				row = 2;
				column = 2;
			}
		}
		if (compare(board[2][2], board[0][0]) == 0) {
			if (compare(board[0][0], computerInput) == 0) {
				row = 1;
				column = 1;
			}
		}
		
		
		
		//d2
		if (compare(board[0][2], board[1][1]) == 0) {
			if (compare(board[0][2], computerInput) == 0) {
				row = 2;
				column = 0;
			}
		}
		if (compare(board[0][2], board[2][0]) == 0) {
			if (compare(board[0][2], computerInput) == 0) {
				row = 1;
				column = 1;
			}
		}
		if (compare(board[1][1], board[2][0]) == 0) {
			if (compare(board[1][1], computerInput) == 0) {
				row = 0;
				column = 2;
			}
		}
		
	
		array[0] = row;
		array[1] = column;
		
		return array;
	}
	

	/**
	 * UC 7
	 * 
	 * @return
	 */
	public int compare(char a, char b) {
		return Character.compare(a,b);
	}
	
	public void resultsForGame() {
		int user_result = 0;
		int computer_result = 0;
		int tie_result = 0;
		for (int i = 0; i < 3; i++) {
			if (compare(board[i][0], board[i][1]) == 0 && compare(board[i][0], board[i][2]) == 0) {
				if (compare(board[i][0], userInput) == 0)
					user_result++;
				if (compare(board[i][0], computerInput) == 0) {
					computer_result++;
				}
			}
			if (compare(board[0][i], board[1][i]) == 0 && compare(board[0][i], board[2][i]) == 0) {
				if (compare(board[0][i], userInput) == 0) {
					user_result++;
				}
				if (compare(board[i][0], computerInput) == 0) {
					computer_result++;
				}
			}
		}
		
		//DIAGONALS
		if ((compare(board[0][0], board[1][1]) == 0 && compare(board[1][1], board[2][2]) == 0)
				|| (compare(board[0][2], board[1][1]) == 0 && compare(board[1][2], board[2][0]) == 0)) {
			if (compare(board[1][1], userInput) == 0)
				user_result++;
			if (compare(board[1][1], computerInput) == 0) {
				computer_result++;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != ' ') {
					tie_result++;
				}
			}
		}
		if (tie_result == 8 ) {
			System.out.println("IT IS A TIE.");
			//System.exit(1);
		}
		if (user_result > 0) {
			System.out.println("USER WINS");
			//System.exit(1);
		}

		if (computer_result > 0) {
			System.out.println("COMPUTER WINS");
			//System.exit(1);

		}

	}

}
