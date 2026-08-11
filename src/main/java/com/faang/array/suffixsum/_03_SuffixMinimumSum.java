package com.faang.array.suffixsum;

import java.util.Arrays;

public class _03_SuffixMinimumSum {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int length = arr.length;
		int[] suffix = new int[length];
		suffix[length - 1] = arr[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] + arr[i];
		}
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			if (suffix[i] < smallest) {
				smallest = suffix[i];
			}
		}
		System.out.println("suffix sum: " + Arrays.toString(suffix));
		System.out.println("min value:" + smallest);
	}
}
