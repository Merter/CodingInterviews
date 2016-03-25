
// Answer 12
import java.util.*;

public class NumberStringCheck {

	private static final Set<Character> DIGITS;
	static {
		DIGITS = new HashSet<Character>(9);
		DIGITS.add('1');
		DIGITS.add('2');
		DIGITS.add('3');
		DIGITS.add('4');
		DIGITS.add('5');
		DIGITS.add('6');
		DIGITS.add('7');
		DIGITS.add('8');
		DIGITS.add('9');
	};
	private static boolean zeroStart;

	public boolean isValidNumber(String str) {
		if (str.length() == 0)
			return false;
		if (str.charAt(0)=='+' || str.charAt(0)=='-')
			return isValidNumber(str, 1);
		if (str.charAt(0) == '.') {
			zeroStart = true;
			return !hasDot(str, 1);
		}
		if (str.charAt(0) == '0') {
			zeroStart = true;
			if (str.length() == 1)
				return true;
			if (str.charAt(1) == '.')
				return !hasDot(str, 2);
			if (str.charAt(1)=='e' || str.charAt(1)=='E')
				return validExponent(str, 2);
			return false;
		}
		if (DIGITS.contains(str.charAt(0)))
			return isValidNumber(str, 1);
		return false;
	}
	
	private boolean isValidNumber(String str, int pos) {
		if (pos == str.length())
			return true;
		if (str.charAt(pos) == '.')
			return !hasDot(str, pos+1);
		if (str.charAt(pos)=='e' || str.charAt(pos)=='E')
			return validExponent(str, pos+1);
		if (str.charAt(pos)=='0' || DIGITS.contains(str.charAt(0)))
			return isValidNumber(str, pos+1);
		return false;
	}
	
	private boolean hasDot(String str, int pos) {
		if (pos == str.length())
			return zeroStart;
		if (str.charAt(pos) == '.')
			return true;
		if (DIGITS.contains(str.charAt(pos)))
			zeroStart = false;
		if (str.charAt(pos)=='e' || str.charAt(pos)=='E') {
			if (zeroStart)
				return true;
			return !validExponent(str, pos+1);
		}
		return hasDot(str, pos+1);
	}
	
	private boolean validExponent(String str, int pos) {
		if (pos == str.length())
			return false;
		if (str.charAt(pos) == 0)
			return str.length()==pos+1;
		for (int i=pos; i<str.length(); i++) {
			if (!DIGITS.contains(str.charAt(i)))
				return false;
		}
		return true;
	}

}
