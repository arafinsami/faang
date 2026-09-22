package com.faang.array.sliding.fixed;

/*
Minimum Sum Sub array of Fixed Size K

1. Build the first window
      i) Add array[index] to windowSum

2. Process the first window
      i) Set minSum = windowSum

3. Slide the window:
      i)   Get the left element  {array[index - windowSize]} and subtract it
      ii)  Get the right element {array[index]} and add it
      iii) Update the answer {minSum}
*/
public class _2_1_MinimumSumSubArray {
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
			if (windowSum < minSum) {
				minSum = windowSum;
			}
		}
		System.out.println(minSum);
	}
}
