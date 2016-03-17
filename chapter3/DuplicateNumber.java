
// Answer 5
public class DuplicateNumber {

	public int findDuplicate(int[] numbers) {
		int missing = 0;
		for (int i=1; i<numbers.length-1; i++) {
			missing ^= i;
		}
		for (int i=0; i<numbers.length; i++) {
			missing ^= numbers[i];
		}
		return missing;
	}
}
