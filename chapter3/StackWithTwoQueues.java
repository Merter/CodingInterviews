
// Answer 22
import java.util.*;

public class StackWithTwoQueues <T> {

	private ArrayDeque<T> queue1 = new ArrayDeque<T>();
	private ArrayDeque<T> queue2 = new ArrayDeque<T>();
	private ArrayDeque<T> pushPopQueue = queue1;
	private ArrayDeque<T> auxQueue = queue2;
	
	public void push(T item) {
		pushPopQueue.addLast(item);
	}
	
	public T pop() {
		if (pushPopQueue.isEmpty())
			return null;
		T item = null;
		while (true) {
			item = pushPopQueue.removeFirst();
			if (pushPopQueue.isEmpty())
				break;
			auxQueue.addLast(item);
		}
		swapQueues();
		return item;
	}
	
	private void swapQueues() {
		ArrayDeque<T> temp = auxQueue;
		auxQueue = pushPopQueue;
		pushPopQueue = temp;	
	}
}
