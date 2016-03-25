
// Answer 16
public class LoopCheck <T> {

	private class Node {
		T item;
		Node next;
	}
	
	public boolean hasLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
}
