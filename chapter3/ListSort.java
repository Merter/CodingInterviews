
// Answer 14
public class ListSort <T extends Comparable<T>> {

	private class Node {
		T item;
		Node next;
	}

	public void sortList(Node head) {
		if (head==null || head.next==null)
			return;
		Node halfHead = halveList(head);
		sortList(head);
		sortList(halfHead);
		head = merge(head, halfHead);
	}
	
	private Node halveList(Node node) {
		Node slow = node;
		Node preSlow = null;
		Node fast = node;
		while (true) {
			preSlow = slow;
			slow = slow.next;
			fast = fast.next;
			if (fast==null)
				break;
			fast = fast.next;
			if (fast==null)
				break;
		}
		preSlow.next = null;
		return slow;
	}

	private Node merge(Node leftHead, Node rightHead) {
		Node head = null;
		Node tail = null;
		while (true) {
			if (leftHead == null) {
				if (rightHead != null) {
					if (tail == null) {
						tail = rightHead;
						head = tail;
					} else
					  tail.next = rightHead;
				}
				break;
			}
			if (rightHead == null) {
				if (tail == null) {
					tail = leftHead;
					head = tail;
				} else
					tail.next = leftHead;
				break;
			}
			int cmp = leftHead.item.compareTo(rightHead.item);
			if (cmp <= 0) {
				if (tail == null) {
					tail = leftHead;
					head = tail;
				} else
					tail.next = leftHead;
				leftHead = leftHead.next;
				tail.next = null;
			} else {
				if (tail == null) {
					tail = rightHead;
					head = tail;
				} else
					tail.next = rightHead;
				rightHead = rightHead.next;
				tail.next = null;
			}
		}
		return head;
	}
}
