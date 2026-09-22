package com.faang.array.sliding.fixed;

/*
Maximum Average Sub array of Fixed Size K

1. Build the first window
      i) Add array[index] to windowSum

2. Process the first window
      i) Calculate the average {windowSum / windowSize}
      ii) Set maxAverage = first window average

3. Slide the window:
      i)   Get the left element  {array[index - windowSize]} and subtract it
      ii)  Get the right element {array[index]} and add it
      iii) Calculate the current window average
      iv)  Update the answer {maxAverage}
*/
public class _3_1_MaximumAverageSubArray {
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
			if ((double) windowSum / windowSize > maxAverageSum) {
				maxAverageSum = (double) windowSum / windowSize;
			}
		}
		System.out.println(maxAverageSum);
	}
}
