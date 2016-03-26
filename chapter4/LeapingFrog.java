
// Answer 24
public class LeapingFrog {

	public int leapCount(int stairs) {
		if (stairs <= 0)
			return 0;
		if (stairs == 1)
			return 1;
		if (stairs == 2)
			return 2;
		return leapCount(stairs-1) + leapCount(stairs-2);
	}

}