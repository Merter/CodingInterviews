

// Answer 31
public class RobotMove {
	private boolean[][] isVisited;
	private int key;
	
	private enum Direction {
		LEFT(-1, 0),
		RIGHT(1, 0),
		UP(0, -1),
		DOWN(0, 1);
		
		private int rowDiff;
		private int colDiff;
		
		private Direction(int r, int c) {
			rowDiff = r;
			colDiff = c;
		}
	}
	
	public int reachCount(int rowSize, int colSize, int key) {
		if (key<0 || rowSize<=0 || colSize<=0)
			return -1;
	
		isVisited = new boolean[rowSize][colSize];
		this.key = key;
		
		isVisited[0][0] = true;
		reachFrom(0, 0, Direction.RIGHT);
		reachFrom(0, 0, Direction.DOWN);

		int count = 0;
		for (int row=0; row<rowSize; row++)
			for (int col=0; col<colSize; col++)
				if (isVisited[row][col])
					count++;
		return count;
	}

	private void reachFrom(int row, int col, Direction direction) {
		int newRow = row+direction.rowDiff;
		int newCol = col+direction.colDiff;
		if (newRow<0 || newRow==isVisited.length)
			return;
		if (newCol<0 || newCol==isVisited[newRow].length)
			return;
		if (isVisited[newRow][newCol])
			return;
		if (digitSumCell(newRow, newCol) > key)
			return;
		isVisited[newRow][newCol] = true;
		reachFrom(newRow, newCol, Direction.LEFT);
		reachFrom(newRow, newCol, Direction.RIGHT);
		reachFrom(newRow, newCol, Direction.UP);
		reachFrom(newRow, newCol, Direction.DOWN);
	}

	private int digitSumCell(int row, int col) {
		return digitSum(row) + digitSum(col);
	}
	
	private int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
