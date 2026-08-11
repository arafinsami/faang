package com.faang.array.suffixsum;

import java.util.Arrays;

public class _04_SuffixCount {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 0 };
		int[] suffix = suffixSum(arr);
		System.out.println(Arrays.toString(suffix));
	}

	private static int[] suffixSum(int[] arr) {
		int[] suffix = new int[arr.length];
		suffix[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1];
			if (arr[i] == 1) {
				suffix[i] = suffix[i] + 1;
			}
		}
		return suffix;
	}
}