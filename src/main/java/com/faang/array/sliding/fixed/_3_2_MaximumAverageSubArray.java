package com.faang.array.sliding.fixed;

public class _3_2_MaximumAverageSubArray {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int length = array.length;
		int windowSize = 2;
		int windowSum = 0;
		double maxAverageSum;
		for (int index = 0; index < windowSize; index++) {
			windowSum = windowSum + array[index];
		}
		maxAverageSum = (double) windowSum / windowSize;
		for (int index = windowSize; index < length; index++) {
			windowSum = windowSum + array[index] - array[index - windowSize];
			maxAverageSum = Math.max(maxAverageSum, (double) windowSum / windowSize);
		}
		System.out.println(maxAverageSum);
	}
}
