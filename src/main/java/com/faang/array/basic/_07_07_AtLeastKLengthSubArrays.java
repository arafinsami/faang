package com.faang.array.basic;

/**
 * CHILD PROBLEM 4
 *
 * Problem:
 *
 * Find all subarrays whose length is AT LEAST K.
 *
 *
 * Formula:
 *
 * subArrayLength = right - left + 1
 *
 *
 * Condition:
 *
 * subArrayLength >= k
 *
 *
 * Example:
 *
 * arr = [1, 4, 2, 5, 3]
 *
 * k = 3
 *
 *
 * At least K means:
 *
 * length >= 3
 *
 * Therefore:
 *
 * length=1
 * length=2
 * length=3  <-- YES
 * length=4  <-- YES
 * length=5  <-- YES
 *
 *
 * All subarrays:
 *
 * left=0: [1]              length=1
 *         [1,4]            length=2
 *         [1,4,2]          length=3  <-- YES
 *         [1,4,2,5]        length=4  <-- YES
 *         [1,4,2,5,3]      length=5  <-- YES
 *
 * left=1: [4]              length=1
 *         [4,2]            length=2
 *         [4,2,5]          length=3  <-- YES
 *         [4,2,5,3]        length=4  <-- YES
 *
 * left=2: [2]              length=1
 *         [2,5]            length=2
 *         [2,5,3]          length=3  <-- YES
 *
 * left=3: [5]              length=1
 *         [5,3]            length=2
 *
 * left=4: [3]              length=1
 *
 *
 * Result:
 *
 * [1,4,2]
 * [1,4,2,5]
 * [1,4,2,5,3]
 * [4,2,5]
 * [4,2,5,3]
 * [2,5,3]
 *
 *
 * Condition:
 *
 * subArrayLength >= k
 *
 * means:
 *
 * greater than K
 *       OR
 * equal to K
 */
public class _07_07_AtLeastKLengthSubArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		int k = 3;
		int length = arr.length;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length; right++) {
				int subArrayLength = right - left + 1;
				if (subArrayLength >= k) {
					System.out.println("left = " + left + ", right = " + right + ", length = " + subArrayLength);
				}
			}
		}
	}
}
