package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _5_5_FirstNonNegativeInWindow {
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
			if (array[index] >= 0) {
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
