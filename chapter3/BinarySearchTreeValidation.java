
// Answer 19
public class BinarySearchTreeValidation {

	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
	}

	public boolean isValid(TreeNode node) {
		int threshold = node.value;
		if (isValid(node.left, Integer.MIN_VALUE, threshold))
			return isValid(node.right, threshold, Integer.MAX_VALUE);
		return false;
	}
	
	private boolean isValid(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		if (node.value < min)
			return false;
		if (node.value >= max)
			return false;
		int threshold = node.value;
		if (isValid(node.left, min, threshold))
			return isValid(node.right, threshold, max);
		return false;
	}

}
