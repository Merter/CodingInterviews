
// Answer 7
public class FullySorted2DMatrix {

	public boolean find(int key, int[][] matrix) {
		int rowSize = matrix[0].length;
		int begin = 0;
		int end = matrix.length*rowSize;
		while (begin < end) {
			int mid = begin + (end-begin)/2;
			int row = mid / rowSize;
			int col = mid % rowSize;
			if (key == matrix[row][col])
				return true;
			if (key < matrix[row][col]) {
				end = mid-1;
			} else {
				begin = mid+1;
			}
		}	
		return false;
	}

}
