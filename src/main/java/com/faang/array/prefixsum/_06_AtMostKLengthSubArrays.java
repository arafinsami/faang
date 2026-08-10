package com.faang.array.prefixsum;

/**
 * CHILD PROBLEM 3
 *
 * Problem:
 *
 * Find all subarrays whose length is AT MOST K.
 *
 *
 * Formula:
 *
 * subArrayLength = right - left + 1
 *
 *
 * Condition:
 *
 * subArrayLength <= k
 *
 *
 * Example:
 *
 * arr = [1, 4, 2, 5, 3]
 *
 * k = 3
 *
 *
 * At most K means:
 *
 * length <= 3
 *
 * Therefore:
 *
 * length=1  <-- YES
 * length=2  <-- YES
 * length=3  <-- YES
 * length=4
 * length=5
 *
 *
 * All subarrays:
 *
 * left=0: [1]              length=1  <-- YES
 *         [1,4]            length=2  <-- YES
 *         [1,4,2]          length=3  <-- YES
 *         [1,4,2,5]        length=4
 *         [1,4,2,5,3]      length=5
 *
 * left=1: [4]              length=1  <-- YES
 *         [4,2]            length=2  <-- YES
 *         [4,2,5]          length=3  <-- YES
 *         [4,2,5,3]        length=4
 *
 * left=2: [2]              length=1  <-- YES
 *         [2,5]            length=2  <-- YES
 *         [2,5,3]          length=3  <-- YES
 *
 * left=3: [5]              length=1  <-- YES
 *         [5,3]            length=2  <-- YES
 *
 * left=4: [3]              length=1  <-- YES
 *
 *
 * Condition:
 *
 * subArrayLength <= k
 *
 * means:
 *
 * smaller than K
 *       OR
 * equal to K
 */
public class _06_AtMostKLengthSubArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		int k = 3;
		int length = arr.length;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length; right++) {
				int subArrayLength = right - left + 1;
				if (subArrayLength <= k) {
					System.out.println( "left = " + left + ", right = " + right + ", length = " + subArrayLength);
				}
			}
		}
	}
}
