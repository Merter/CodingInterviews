
// Answer1
public class PalindromeNumbers {

	public boolean isPalindrome(int number) {
		int digits = (int)Math.floor(Math.log10(number))+1;
		int tenPower = (int)Math.pow(10, digits-1);
		while (digits > 1) {
			int mostSignificant = number / tenPower;
			int leastSignificant = number % 10;
			if (mostSignificant != leastSignificant)
				return false;
			number -= mostSignificant * tenPower;
			number /= 10;
			digits -= 2;
			tenPower /= 10;
		}
		return true;
	}
	
	public boolean isPalindromeByReversing(int number) {
		int reverse = 0;
		while (number > 0) {
			reverse *= 10;
			reverse += number%10;
			number /= 10;
		}		
		return reverse == number;
	}

}
