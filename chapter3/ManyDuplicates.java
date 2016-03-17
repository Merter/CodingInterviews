
// Answer 6
import java.util.*;

public class ManyDuplicates {

	public int findADuplicate(int[] numbers) {
		if (numbers==null || numbers.length<2)
			return -1;
		Arrays.sort(numbers);
		int begin = 0;
		int end = numbers.length-1;
		while (numbers[begin] < numbers[end]) {
			int mid = begin + (end-begin)/2;
			if (mid > numbers[mid]) {
				end = mid;
			} else {
				begin = mid;
			}
		}
		return numbers[begin];
	}

}
