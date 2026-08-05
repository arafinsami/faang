package com.faang.array.basic;

/**
 * Input:
 *
 * int[] arr = {2, 4, 2};
 *
 * Goal:
 *
 * Find an index where the sum of all elements on the left
 * is equal to the sum of all elements on the right.
 *
 * Such an index is called the Equilibrium Index.
 *
 *
 * Step 1: Create the Prefix Array
 * int[] prefix = new int[arr.length];
 *
 * Initially,
 * arr    = [2, 4, 2]
 * prefix = [0, 0, 0]
 *
 * Step 2: Build the Prefix Sum Array
 * prefix[0] = arr[0];
 * prefix = [2, 0, 0]
 *
 * Loop starts from index 1.
 *
 * Formula:
 * prefix[i] = prefix[i - 1] + arr[i];
 *
 * Iteration 1
 * i = 1
 * prefix[1] = 2 + 4
 *           = 6
 *
 * prefix = [2, 6, 0]
 *
 * Iteration 2
 * i = 2
 *
 * prefix[2] = 6 + 2
 *           = 8
 *
 * prefix = [2, 6, 8]
 *
 * Step 3: Find the Total Sum
 * total = prefix[length - 1];
 *
 * total = 8
 *
 * Step 4: Check Every Index
 * Formula:
 *
 * leftSum  = (i == 0) ? 0 : prefix[i - 1];
 * rightSum = total - prefix[i];
 *
 * If leftSum == rightSum,
 * return the current index.
 *
 * Iteration 1
 * i = 0
 * leftSum  = 0
 * rightSum = 8 - 2
 *          = 6
 *
 * 0 != 6
 * Continue...
 *
 * Iteration 2
 * i = 1
 * leftSum  = prefix[0]
 *          = 2
 *
 * rightSum = 8 - 6
 *          = 2
 *
 * leftSum == rightSum
 * Equilibrium Index Found!
 *
 * return 1
 *
 * Final Output
 * Equilibrium Index = 1
 *
 *
 * Verification
 * Array:
 * [2, 4, 2]
 * Left Side of index 1: 2
 * Right Side of index 1: 2
 *
 * Since both sums are equal,
 * index 1 is the Equilibrium Index.
 *
 * Key Idea
 * Instead of calculating the left and right sums
 * repeatedly for every index,
 * we first build a Prefix Sum array.
 *
 * Using the prefix array:
 *
 * leftSum  = prefix[i - 1]
 * rightSum = total - prefix[i]
 *
 * Both values are obtained in O(1),
 * making the entire algorithm run in O(n) time.
 */
public class _07_02_EquilibriumIndex {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int prefix = findEquilibrium(arr);
		System.out.println(prefix);
	}

	private static int findEquilibrium(int[] arr) {
		int length = arr.length;
		int[] prefix = new int[length];
		prefix[0] = arr[0];
		for (int i = 1; i < length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		int total = prefix[length - 1];
		for (int i = 0; i < arr.length; i++) {
			int leftSum = (i == 0) ? 0 : prefix[i - 1];
			int rightSum = total - prefix[i];
			if (leftSum == rightSum) {
				return i;
			}
		}
		return -1;
	}
}

