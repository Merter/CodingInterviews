
// Answer 23
public class FibonacciNumbers {

	public int nthFibonacci(int n) {
		if (n < 1)
			return 0;
		if (n < 3)
			return 1;
		int twoPrev = 1;
		int onePrev = 1;
		for (int i=2; i<=n; i++) {			
			onePrev += twoPrev;
			twoPrev = onePrev-twoPrev;
		}
		return onePrev;
	}

}