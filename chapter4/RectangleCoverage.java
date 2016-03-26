
// Answer 26
public class RectangleCoverage {

	public int coverageCount(int col) {
		if (col == 0)
			return 0;
		if (col == 1)
			return 1;
		return coverageCount(col-1) + coverageCount(col-2);
	}
}
