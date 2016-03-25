
// Answer 18
public class NextTreeNode <T> {

	private class TreeNode {
		T item;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
	}
	
	public T nextValue(TreeNode node) {
		if (node == null)
			return null;
		if (node.right != null) {
			return leftMost(node.right).item;
		}
		TreeNode next = parentHavingThisInLeftSubtree(node);
		return next!=null ? next.item : node.item;
	}
	
	private TreeNode leftMost(TreeNode node) {
		if (node.left == null)
			return node;
		return leftMost(node.left);
	}

	private TreeNode parentHavingThisInLeftSubtree(TreeNode node) {
		if (node.parent == null)
			return null;
		if (node == node.parent.left)
			return node.parent;
		return parentHavingThisInLeftSubtree(node.parent);
	}

}
