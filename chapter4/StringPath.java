
// Answer 30
public class StringPath {

	private boolean[][] isVisited;
	private char[][] matrix;
	private String key;

	private enum Direction {
		LEFT(-1, 0), 
		RIGHT(1, 0), 
		DOWN(0, 1), 
		UP(0, -1);

		private int rowDiff;
		private int colDiff;
		
		private Direction(int r, int c) {
			rowDiff = r;
			colDiff = c;
		}
	}

	public boolean isTherePath(char[][] matrix, String key) {
		this.matrix = matrix;
		this.key = key;
		isVisited = new boolean[matrix.length][matrix[0].length];
		for (int row=0; row<matrix.length; row++) {
			for (int col=0; col<matrix[row].length; col++) {
				if (key.charAt(0) == matrix[row][col]) {
					isVisited[row][col] = true;
					if (recursivePath(row, col, Direction.LEFT, 1))
						return true;
					if (recursivePath(row, col, Direction.RIGHT, 1))
						return true;
					if (recursivePath(row, col, Direction.UP, 1))
						return true;
					if (recursivePath(row, col, Direction.DOWN, 1))
						return true;
					isVisited[row][col] = false;
				}
			}
		}
		return false;					
	}
	
	private boolean recursivePath(int row, int col, Direction direction, int index) {
		if (index == key.length())
			return true;
		int newRow = direction.rowDiff+row;
		int newCol = direction.colDiff+col;
		if (newRow<0 || newRow==matrix.length)
			return false;
		if (newCol<0 || newCol==matrix[row].length)
			return false;
		if (matrix[newRow][newCol] != key.charAt(index))
			return false;
		if (isVisited[newRow][newCol])
			return false;

		isVisited[row][col] = true;
		if (recursivePath(newRow, newCol, Direction.LEFT, index+1))
			return true;
		if (recursivePath(newRow, newCol, Direction.RIGHT, index+1))
			return true;
		if (recursivePath(newRow, newCol, Direction.UP, index+1))
			return true;
		if (recursivePath(newRow, newCol, Direction.DOWN, index+1))
			return true;
		isVisited[row][col] = false;
		return false;
	}

}
