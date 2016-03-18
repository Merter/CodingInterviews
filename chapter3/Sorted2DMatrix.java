
// Answer 8
public class Sorted2DMatrix<T extends Comparable<T>> {

  public int[] findInSortedMatrix(T key, T[][] matrix) {
    return findInSortedMatrixByRowColumnElimination(key, matrix, matrix.length-1, 0);
  }

  private int[] findInSortedMatrixByRowColumnElimination(T key, T[][]matrix, int row, int col) {
    if (row < 0)
      return null;
    if (col == matrix[row].length)
      return null;
    int cmp = key.compareTo(matrix[row][col]);
    if (cmp == 0)
      return new int[] {row, col};
    if (cmp < 0)
      return findInSortedMatrixByRowColumnElimination(key, matrix, row-1, col);
    return findInSortedMatrixByRowColumnElimination(key, matrix, row, col+1);
  }
}
