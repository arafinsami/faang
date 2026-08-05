package com.faang.array.basic;

import java.util.Arrays;

/**
 *
 * Input: int[] arr = {2, 4, 6};
 *
 * Step 1: Create the Prefix Array
 *
 * int[] prefix = new int[arr.length];
 *
 * Creates a new array of the same size as the original array.
 *
 * Initially,
 * arr    = [2, 4, 6]
 * prefix = [0, 0, 0]
 *
 * The prefix array is filled with zeros by default.
 *
 * Step 2: Initialize the First Element
 *
 * prefix[0] = arr[0];
 *
 * Since there are no previous elements before index 0,
 * the first prefix sum is simply the first element itself.
 *
 * Calculation:
 * prefix[0] = 2
 * Now,
 * arr    = [2, 4, 6]
 * prefix = [2, 0, 0]
 *
 * Step 3: Start the Loop
 *
 * for (int i = 1; i < arr.length; i++)
 *
 * The loop starts from index 1 because index 0 has
 * already been calculated.
 *
 * Formula used in every iteration:
 * prefix[i] = prefix[i - 1] + arr[i];
 *
 * This means:
 *
 * Take the previous prefix sum
 * + Add the current array element
 * = Store the new prefix sum
 *
 * Iteration 1
 * i = 1
 * Current values:
 * prefix[0] = 2
 * arr[1] = 4
 *
 * Calculation:
 * prefix[1] = prefix[0] + arr[1]
 *           = 2 + 4
 *           = 6
 *
 * Updated prefix array:
 * prefix = [2, 6, 0]
 * Meaning:
 * prefix[1] = 2 + 4
 *           = 6
 *
 * Iteration 2
 * i = 2
 * Current values:
 * prefix[1] = 6
 * arr[2] = 6
 * 
 * Calculation:
 * prefix[2] = prefix[1] + arr[2]
 *           = 6 + 6
 *           = 12
 *
 * Updated prefix array:
 *
 * prefix = [2, 6, 12]
 *
 * Meaning:
 *
 * prefix[2] = (2 + 4) + 6
 *           = 12
 *
 * Final Output
 * arr    = [2, 4, 6]
 * prefix = [2, 6, 12]
 *
 * What Each Prefix Value Represents
 * prefix[0] = 2
 *           = 2
 * prefix[1] = 6
 *           = 2 + 4
 *
 * prefix[2] = 12
 *           = 2 + 4 + 6
 *
 * Key Idea
 * Without Prefix Sum:
 * To find the sum up to index 2, we calculate:
 * 2 + 4 + 6 = 12
 * 
 * every time it is needed.
 *
 * With Prefix Sum:
 * We already know:
 * prefix[1] = 6
 *
 * So,
 * prefix[2] = prefix[1] + arr[2]
 *           = 6 + 6
 *           = 12
 *
 * Instead of adding all previous elements again,
 * we reuse the previous prefix sum and add only the
 * current element.
 *
 * This is why the Prefix Sum algorithm runs in O(n) time.
 */
public class _07_01_PrefixSum {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int[] prefix = prefixSum(arr);
		System.out.println(Arrays.toString(prefix));
	}

	private static int[] prefixSum(int[] arr) {
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		return prefix;
	}
}
