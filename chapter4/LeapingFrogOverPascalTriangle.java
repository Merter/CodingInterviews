
// Answer 25
import java.util.*;

public class LeapingFrogOverPascalTriangle {

	public int differentWays(int stepCount) {
		if (stepCount <= 0)
			return 0;
		if (stepCount == 1)
			return 1;
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		for (int counter=2; counter<stepCount; counter++) {
			int[] newInts = new int[list.size()+1];
			int prev = 0;
			int intCounter = 0;
			for (int i : list) {
				newInts[intCounter++] = prev+i;
				prev = i;
			}
			newInts[list.size()] = 1;
			list = new LinkedList<Integer>();
			for (int i : newInts)
				list.add(i);
		}
		int total = 0;
		for (int i : list)
			total += i;
		return total;
	}

}
