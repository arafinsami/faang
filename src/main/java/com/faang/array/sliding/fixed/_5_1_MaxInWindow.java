package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Maximum in Every Window of Fixed Size K

1. Build / slide the window for each index:

      i) Remove indices from the front that are outside the current window
         {deque.peekFirst() < index - windowSize + 1}

      ii) Remove indices from the back whose values are smaller
          than the current element
          {array[deque.peekLast()] < array[index]}

      iii) Add the current index to the back of the deque

2. Process the window:

      i) When the first complete window is formed
         {index >= windowSize - 1}

      ii) The index at the front of the deque represents
          the maximum element of the current window

      iii) Add {array[deque.peekFirst()]} to the result
*/
public class _5_1_MaxInWindow {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int length = array.length;
		int windowSize = 2;
		List<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int index = 0; index < length; index++) {
			while (!deque.isEmpty() && deque.peekFirst() < index - windowSize + 1) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && array[deque.peekLast()] < array[index]) {
				deque.removeLast();
			}
			deque.addLast(index);
			if (index >= windowSize - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		System.out.println(result);
	}
}
