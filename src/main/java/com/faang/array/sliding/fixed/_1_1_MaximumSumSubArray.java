package com.faang.array.sliding.fixed;

public class _1_1_MaximumSumSubArray {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 5 };
		int length = array.length;
		int windowSize = 2;
		int windowSum = 0;
		int maxSum = 0;
		for (int index = 0; index < windowSize; index++) {
			windowSum = windowSum + array[index];
		}
		for (int index = windowSize; index < length; index++) {
			windowSum = windowSum + array[index] - array[index - windowSize];
			if (windowSum > maxSum) {
				maxSum = windowSum;
			}
		}
		System.out.println(maxSum);
	}
}
