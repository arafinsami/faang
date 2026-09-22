package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Minimum-Maximum Difference in Every Window of Fixed Size K

1. Build / slide the window for each index:

      i) Remove indices from the front of maxDeque
         that are outside the current window
         {maxDeque.peekFirst() < index - windowSize + 1}

      ii) Remove indices from the front of minDeque
          that are outside the current window
          {minDeque.peekFirst() < index - windowSize + 1}

      iii) Remove indices from the back of maxDeque
           whose values are smaller than the current element
           {array[maxDeque.peekLast()] < array[index]}

      iv) Remove indices from the back of minDeque
          whose values are greater than the current element
          {array[minDeque.peekLast()] > array[index]}

      v) Add the current index to both deques

2. Process the window:

      i) When the first complete window is formed
         {index >= windowSize - 1}

      ii) Get maximum value from the front of maxDeque
          {array[maxDeque.peekFirst()]}

      iii) Get minimum value from the front of minDeque
           {array[minDeque.peekFirst()]}

      iv) Calculate difference
          {maxValue - minValue}

      v) Add the difference to the result
*/
public class _5_3_MinMaxDiffInWindow {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int length = array.length;
		int windowSize = 2;
		List<Integer> result = new ArrayList<Integer>();
		Deque<Integer> maxDeque = new ArrayDeque<Integer>();
		Deque<Integer> minDeque = new ArrayDeque<Integer>();
		for (int index = 0; index < length; index++) {
			while (!maxDeque.isEmpty() && maxDeque.peekFirst() < index - windowSize + 1) {
				maxDeque.removeFirst();
			}
			while (!minDeque.isEmpty() && minDeque.peekFirst() < index - windowSize + 1) {
				minDeque.removeFirst();
			}
			while (!maxDeque.isEmpty() && array[maxDeque.peekLast()] < array[index]) {
				maxDeque.removeLast();
			}
			while (!minDeque.isEmpty() && array[minDeque.peekLast()] > array[index]) {
				minDeque.removeLast();
			}
			maxDeque.addLast(index);
			minDeque.addLast(index);
			if (index >= windowSize - 1) {
				int maxValue = array[maxDeque.peekFirst()];
				int minValue = array[minDeque.peekFirst()];
				int difference = maxValue - minValue;
				result.add(difference);
			}
		}
		System.out.println(result);
	}
}

