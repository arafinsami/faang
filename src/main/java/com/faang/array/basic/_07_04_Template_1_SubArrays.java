package com.faang.array.basic;


/**
 * TEMPLATE 1 - GENERATE ALL SUBARRAYS BY INDICES
 *
 * Use this whenever the problem says:
 *
 * - all subarrays
 * - contiguous subarrays
 * - every possible subarray
 * - inspect every possible [left ... right]
 * Example:
 * arr = [1, 4, 2]
 * left  = starting index
 * right = ending index
 * So visually:
 *
 * left=0: [1]
 *         [1,4]
 *         [1,4,2]
 *
 * left=1: [4]
 *         [4,2]
 *
 * left=2: [2]
 *
 *
 * How the loops work:
 *
 * left = 0
 *
 * right = 0  ->  [1]
 * right = 1  ->  [1,4]
 * right = 2  ->  [1,4,2]
 *
 * left = 1
 *
 * right = 1  ->  [4]
 * right = 2  ->  [4,2]
 *
 * left = 2
 *
 * right = 2  ->  [2]
 *
 * PATTERN:
 *
 * for each LEFT
 *      |
 *      v
 * try every RIGHT starting from LEFT
 *      |
 *      v
 * arr[left ... right]
 *
 *
 * IMPORTANT:
 *
 * right starts from left:
 *
 * right = left
 *
 * because the ending index cannot come
 * before the starting index.
 */
public class _07_04_Template_1_SubArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2 };
		int length = arr.length;
		// Choose starting index
		for (int left = 0; left < length; left++) {
			// Choose ending index
			for (int right = left; right < length; right++) {
				// Print current subarray
				System.out.print("left=" + left);
				System.out.print(", right=" + right);
				System.out.print(" -> [");
				// Print elements from left to right
				for (int i = left; i <= right; i++) {

					System.out.print(arr[i]);

					if (i < right) {
						System.out.print(",");
					}
				}
				System.out.println("]");
			}
		}
	}
}
