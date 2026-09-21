package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _4_MaxInWindow {
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
