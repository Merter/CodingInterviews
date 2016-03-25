
// Answer 21
import java.util.*;

public class QueueWithTwoStacks <T> {

	private ArrayDeque<T> oldItems = new ArrayDeque<T>();
	private ArrayDeque<T> newItems = new ArrayDeque<T>();

	public void enqueue(T item) {
		oldItems.push(item);
	}
	
	public T dequeue() {
		if (!newItems.isEmpty())
			return newItems.pop();
		while (!oldItems.isEmpty()) {
			newItems.push(oldItems.pop());
		}
		return newItems.pop();
	}

}
