
// Answer 28
public class TurningPoint {

	public int turnsAt(int[] numbers) {
		if (numbers==null || numbers.length==0)
			return -1;
			
		int begin = 0;
		int end = numbers.length;
		int mid;
		while (true) {
			mid = begin + (end-begin)/2;
			if (mid+1 > end)
				break;
			if (numbers[mid] <= numbers[mid+1]) {
				begin = mid+1;
				continue;	
			}
			
			if (mid-1 < begin)
				break;
			if (numbers[mid-1] > numbers[mid]) {
				end = mid-1;
				continue;
			}
			break;
		}
		return mid;
	}

}
