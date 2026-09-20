package com.faang.array.sliding.fixed;

public class _2_2_MinimumSumSubArray {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int length = array.length;
		int windowSize = 2;
		int windowSum = 0;
		int minSum = 0;
		for (int index = 0; index < windowSize; index++) {
			windowSum = windowSum + array[index];
		}
		for (int index = windowSize; index < length; index++) {
			windowSum = windowSum + array[index] - array[index - windowSize];
			minSum = Math.min(minSum, windowSum);
		}
		System.out.println(minSum);
	}
}
