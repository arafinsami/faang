package com.faang.array.sliding.fixed;

/*
Maximum Sum Sub array of Fixed Size K

1. Build the first window
      i) Add array[index] to windowSum

2. Process the first window
      i) Set maxSum = windowSum

3. Slide the window:
      i)   Get the left element  {array[index - windowSize]} and subtract it
      ii)  Get the right element {array[index]} and add it
      iii) Update the answer {maxSum}
*/
public class _1_2_MaximumSumSubArray {
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
			maxSum = Math.max(maxSum, windowSum);
		}
		System.out.println(maxSum);
	}
}
