package skrudra.alads.tictactoegame;

public class TicTacToe {

	protected char[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	protected char currentMarker;

	public TicTacToe(char playerToken, char aiMarker) {
		this.userMarker = playerToken;
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.board = setBoard();
	}

	private char[] setBoard() {
		char[] board = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

	public boolean playTurn(int spot) {
		boolean isValid = withinRang(spot) && !isSpotTaken(spot);
		if (isValid) {
			board[spot - 1] = (this.currentMarker == this.userMarker) ? this.aiMarker : this.userMarker;
		}
		return isValid;
	}

	public void printVoid() {
		System.out.println();
		for (int i = 0; i < this.board.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("--------------------------------");
			}
			System.out.println(" | " + board[i]);
		}
		System.out.println();
	}

	public void printIndexBoard() {
		System.out.println();
		for (int i = 0; i < this.board.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("--------------------------------");
			}
			System.out.println(" | " + i + 1);
		}
		System.out.println();
	}

	private boolean isSpotTaken(int spot) {
		return this.board[spot - 1] != '-';
	}

	private boolean withinRang(int spot) {
		return spot > 0 && spot < board.length - 1;
	}
}

