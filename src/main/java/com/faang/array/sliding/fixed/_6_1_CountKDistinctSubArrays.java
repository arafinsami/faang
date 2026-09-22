package com.faang.array.sliding.fixed;

import java.util.HashMap;
import java.util.Map;

/*
1. build first window
2. process it
3. slide window:
      i)get the left element{array[index-windowSize]} and remove left element
      ii)get the right element{array[index]} and add right element
      iii)update answer
 */
public class _6_1_CountKDistinctSubArrays {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int windowSize = 2;
		int length = array.length;
		int counter = 0;
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int index = 0; index < windowSize; index++) {
			frequency.put(array[index], frequency.getOrDefault(array[index], 0) + 1);
		}
		if (frequency.size() == windowSize) {
			counter++;
		}
		for (int index = windowSize; index < length; index++) {
			int leftElement = array[index - windowSize];
			frequency.put(leftElement, frequency.get(leftElement) - 1);
			if (frequency.get(leftElement) == 0) {
				frequency.remove(leftElement);
			}
			int rightElement = array[index];
			frequency.put(rightElement, frequency.getOrDefault(rightElement, 0) + 1);
			if (frequency.size() == windowSize) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}

