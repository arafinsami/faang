package com.faang.array.basic;

import java.util.Arrays;

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
