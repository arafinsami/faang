package com.faang.array.suffixsum;

import java.util.Arrays;

public class _01_SuffixSum {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int[] suffix = suffixSum(arr);
		System.out.println(Arrays.toString(suffix));
	}

	private static int[] suffixSum(int[] arr) {
		int[] suffix = new int[arr.length];
		suffix[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			suffix[i] = arr[i] + suffix[i + 1];
		}
		return suffix;
	}
}