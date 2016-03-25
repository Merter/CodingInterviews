
// Answer 11
public class SimpleRegularExpression {

	public boolean doesMatch(String str, String pattern) {
		return doesMatch(str, 0, pattern, 0);
	}

	private boolean doesMatch(String str, int strPos, String pattern, int patPos) {
		if (patPos == pattern.length()) {
			return (strPos == str.length());
		}	
		if (strPos == str.length())
			return false;
			
		boolean isRepeatable = false;
		if (patPos+1<pattern.length() && pattern.charAt(patPos+1)=='*')
			isRepeatable = true;
		if (!isRepeatable) {
			if (pattern.charAt(patPos) == '.')
				return doesMatch(str, strPos+1, pattern, patPos+1);
			if (str.charAt(strPos) != pattern.charAt(patPos))
				return false;
			return doesMatch(str, strPos+1, pattern, patPos+1);
		}
		int repeat = 0;
		while (str.charAt(strPos+repeat) == pattern.charAt(patPos)) {
			if (doesMatch(str, strPos+repeat, pattern, patPos+2))
				return true;
			repeat++;
		}
		return doesMatch(str, strPos, pattern, patPos+2);
	}

}