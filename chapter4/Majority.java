
// Answer 29

// 1. option: Sort the array. The element in the middle is majority. O(nlogn)
// 2. option: Count all elements one by one. O(n) time and memory

import java.util.*;
							
public class Majority {

	// O(nlogn) time, O(logn) space with quicksort average case
	// O(n) time, O(n) space with quicksort worst case
	public int majorityBySorting(int[] numbers) {
		Arrays.sort(numbers);
		int mid = numbers.length/2;
		return numbers[mid];
	}
	
	// O(n) time, O(n) space
	public int majorityByCounting(int[] numbers) {
		Map<Integer, Integer> counters = new HashMap<Integer, Integer>();
		for (int i=0; i<numbers.length; i++) {
			Integer c = counters.get(numbers[i]);
			if (c == null)
				counters.put(numbers[i], 1);
			else {
				c++;
				if (c > numbers.length/2)
					return numbers[i];
				counters.put(numbers[i], c);
			}
		}
		return Integer.MIN_VALUE;
	}
	
	// O(logn) time, O(logn) space with partition average case
	// O(n) time, O(n) space with partition worst case
	public int majorityByPartition(int[] numbers) {
		return majorityByPartitionInRange(numbers, 0, numbers.length-1);
	}

	private int majorityByPartitionInRange(int[] numbers, int begin, int end) {
		int pivotIndex = partition(numbers, begin, end);
		if (pivotIndex == numbers.length/2)
			return pivotIndex;
		
		if (pivotIndex < numbers.length/2)
			return majorityByPartitionInRange(numbers, pivotIndex+1, numbers.length-1);
			
		return majorityByPartitionInRange(numbers, 0, pivotIndex-1);
	}

	private int partition(int[] numbers, int begin, int end) {
		int pivot = numbers[begin];
		int smallers = begin;
		int biggers = end+1;
		while (true) {
			while (smallers<end && numbers[++smallers]<=pivot);
			while (numbers[--biggers]>pivot);
			if (smallers < biggers)
				swap(numbers, smallers, biggers);
			else {
				swap(numbers, begin, biggers);
				return biggers;
			}
		}
	}
		
	private void swap(int numbers[], int from, int to) {
		int temp = numbers[from];
		numbers[from] = numbers[to];
		numbers[to] = temp;
	}

	// O(n) time, O(1) space
	public int majorityBySingleCounter(int[] numbers) {
		int last = numbers[0];
		int counter = 1;
		for (int i=1; i<numbers.length; i++) {
			if (numbers[i] == last) {
				counter++;
			} else {
				counter--;
				if (counter == 0) {
					last = numbers[i];
					counter = 1;
				}
			}
		}
		return last;
	}

}
