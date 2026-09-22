package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
First Negative Number in Every Window of Fixed Size K

1. Build / slide the window for each index:

      i) Remove indices from the front that are outside
         the current window
         {deque.peekFirst() < index - windowSize + 1}

      ii) Check whether the current element is negative
          {array[index] < 0}

      iii) If negative, add its index to the back of the deque

2. Process the window:

      i) When the first complete window is formed
         {index >= windowSize - 1}

      ii) If deque is not empty:
          - The index at the front represents the
            first negative number in the current window
          - Add {array[deque.peekFirst()]} to the result

      iii) If deque is empty:
           - There is no negative number in the current window
           - Add 0 to the result
*/
public class _5_4_FirstNegativeInWindow {
	public static void main(String[] args) {
		int[] array = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int length = array.length;
		int windowSize = 2;
		List<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int index = 0; index < length; index++) {
			while (!deque.isEmpty() && deque.peekFirst() < index - windowSize + 1) {
				deque.removeFirst();
			}
			if (array[index] < 0) {
				deque.addLast(index);
			}
			if (index >= windowSize - 1) {
				if (!deque.isEmpty()) {
					result.add(array[deque.peekFirst()]);
				} else {
					result.add(0);
				}
			}
		}
		System.out.println(result);
	}
}
