
// Answer 15
public class SortedListMerger <T extends Comparable<T>> {

	private class Node {
		T item;
		Node next;	
	}

	public Node merge(Node first, Node second) {
		Node head = null;
		Node tail = null;
		while (true) {
			if (first == null) {
				if (tail == null)
					head = second;
				else
					tail.next = second;
				break;
			}
			if (second == null) {
				if (tail == null)
					head = first;
				else
					tail.next = first;
				break;
			}
			int cmp = first.item.compareTo(second.item);
			if (cmp <= 0)
				addToTail(head, tail, first);
			else
				addToTail(head, tail, second);
		}
		return head;
	}

	private void addToTail(Node head, Node tail, Node node) {
		if (tail == null) {
			tail = node;
			head = node;
			node = node.next;
			tail.next = null;
		} else {
			tail.next = node;
			tail = tail.next;
			node = node.next;
			tail.next = null;
		}
	}
}
