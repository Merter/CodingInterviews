
// Answer 20
public class MaxBinarySearchTree {

	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
	}
	
	public int maxNodeCount(TreeNode node) {
		if (isBst(node))
			return nodeCount(node);
		return Math.max(maxNodeCount(node.left), maxNodeCount(node.right));
	}

	private boolean isBst(TreeNode node) {
		return isBstInRange(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	private boolean isBstInRange(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		int threshold = node.value;
		if (threshold<min || threshold>=max)
			return false;
		if (isBstInRange(node.left, min, threshold))
			return isBstInRange(node.right, threshold, max);
		return false;
	}

	private int nodeCount(TreeNode node) {
		if (node == null)
			return 0;
		return nodeCount(node.left)+1+nodeCount(node.right);
	}

}
