package Assignment;
import java.util.Scanner;
import java.util.*;

public class TicTacToe {
	public char[][] board;
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.createBoard();
		game.chooseLetter();
	}
	
	public void createBoard(){
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public void chooseLetter() {
		Scanner scanner = new Scanner(System.in);
		char computer;
		char user;
		do {
			System.out.println("Player 1: Choose X or O");
			user = scanner.next().charAt(0);	
		
				switch(user) {
					case 'X':
						computer = 'O';
						break;
						
					case 'O':
						computer = 'X';
						break;
						
					default:
						System.out.println("Enter correct input");
						break;
				}
		}
		while (user !='X'&& user !='O');
	}
	 
}




