package task4;

public class SudokuSolver {
	public static void main(String[] args) {
		int[][] puzzle = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		if (solveSudoku(puzzle)) {
			System.out.println("Sudoku puzzle solved:");
			printBoard(puzzle);
		} else {
			System.out.println("No solution exists.");
		}
	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean solveSudoku(int[][] board) {
		int row, col;

		// Check if there are any empty cells left
		if (!findEmptyLocation(board, (row = 0), (col = 0)))
			return true;

		// Try digits 1 through 9
		for (int num = 1; num <= 9; num++) {
			if (isValidMove(board, row, col, num)) {
				// If the move is valid, make it and then recursively solve the puzzle
				board[row][col] = num;

				if (solveSudoku(board))
					return true;

				// If the recursive solving failed, backtrack and try a different number
				board[row][col] = 0;
			}
		}

		// If no number works, the puzzle is unsolvable
		return false;
	}

	public static boolean findEmptyLocation(int[][] board, int[] row, int[] col) {
		for (row[0] = 0; row[0] < 9; row[0]++) {
			for (col[0] = 0; col[0] < 9; col[0]++) {
				if (board[row[0]][col[0]] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isValidMove(int[][] board, int row, int col, int num) {
		return !isNumInRow(board, row, num) && !isNumInCol(board, col, num)
				&& !isNumInBox(board, row - row % 3, col - col % 3, num);
	}

	public static boolean isNumInRow(int[][] board, int row, int num) {
		for (int col = 0; col < 9; col++) {
			if (board[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumInCol(int[][] board, int col, int num) {
		for (int row = 0; row < 9; row++) {
			if (board[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumInBox(int[][] board, int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row + boxStartRow][col + boxStartCol] == num) {
					return true;
				}
			}
		}
		return false;
	}
}
