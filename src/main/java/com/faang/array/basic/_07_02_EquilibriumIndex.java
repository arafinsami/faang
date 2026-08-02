package com.faang.array.basic;

public class _07_02_EquilibriumIndex {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int prefix = findEquilibrium(arr);
		System.out.println(prefix);
	}

	private static int findEquilibrium(int[] arr) {
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		int total = prefix[arr.length - 1];
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
