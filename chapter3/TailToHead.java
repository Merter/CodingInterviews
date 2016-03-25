
// Answer 13
public class TailToHead {

	private class Node {
		String value;
		Node next;
	}

	public void printFromTail(Node node) {
		if (node == null)
			return;
		if (node.next == null) {
			System.out.println(node.value);
			return;
		}
		
		printFromTail(node.next);
		System.out.println(node.value);
	}

}