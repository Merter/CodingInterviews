
// Answer 17
public class LoopStart <T> {

	private class Node {
		T item;
		Node next;
	}
	
	public Node loopStart(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

}
