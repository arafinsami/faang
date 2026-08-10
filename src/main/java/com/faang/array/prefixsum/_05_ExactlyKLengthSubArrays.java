package com.faang.array.prefixsum;

public class _05_ExactlyKLengthSubArrays {

	/**
     * CHILD PROBLEM 2
     *
     * Problem:
     *
     * Print all subarrays whose length is exactly K.
     *
     *
     * Formula:
     *
     * subArrayLength = right - left + 1
     *
     *
     * Condition:
     *
     * subArrayLength == k
     *
     *
     * Example:
     *
     * arr = [1, 4, 2, 5, 3]
     *
     * k = 3
     *
     *
     * All subarrays:
     *
     * left=0: [1]              length=1
     *         [1,4]            length=2
     *         [1,4,2]          length=3  <-- YES
     *         [1,4,2,5]        length=4
     *         [1,4,2,5,3]      length=5
     *
     * left=1: [4]              length=1
     *         [4,2]            length=2
     *         [4,2,5]          length=3  <-- YES
     *         [4,2,5,3]        length=4
     *
     * left=2: [2]              length=1
     *         [2,5]            length=2
     *         [2,5,3]          length=3  <-- YES
     *
     *
     * Result:
     *
     * [1,4,2]
     * [4,2,5]
     * [2,5,3]
     */
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		int k = 3;
		int length = arr.length;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length; right++) {
				int subArrayLength = right - left + 1;
				if (subArrayLength == k) {
					System.out.println(
	                        "left = " + left +
	                        ", right = " + right +
	                        ", length = " + subArrayLength);
				}
			}
		}
	}
}
