
// Answer 27
public class MinimumInSortedRotated {

	public int minimumIn(int[] sortedRotated) {
		if (sortedRotated==null || sortedRotated.length==0)
			return Integer.MIN_VALUE;
		return minimumInRange(sortedRotated, 0, sortedRotated.length-1);	
	}
	
	private int minimumInRange(int[] sortedRotated, int begin, int end) {
		int mid = begin+(end-begin) / 2;
		if (begin == mid)
			return sortedRotated[begin];
			
		if (sortedRotated[begin] < sortedRotated[mid])
			return Math.min(sortedRotated[begin], minimumInRange(sortedRotated, mid+1, end));
			
		if (sortedRotated[begin] > sortedRotated[mid]) 
			return Math.min(sortedRotated[mid], minimumInRange(sortedRotated, begin, mid-1));
			
		int min = sortedRotated[begin];
		for (int i=begin+1; i<=end; i++) {
			if (sortedRotated[i] < min)
				min = sortedRotated[i];
		}
		return min;
	}
}