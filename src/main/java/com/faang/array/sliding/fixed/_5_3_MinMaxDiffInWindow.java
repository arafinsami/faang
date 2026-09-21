package com.faang.array.sliding.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

