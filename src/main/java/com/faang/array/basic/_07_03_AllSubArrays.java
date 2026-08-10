package com.faang.array.basic;

public class _07_03_AllSubArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
		int length = arr.length;
		int[] prefix = new int[length];
		prefix[0] = arr[0];
		for (int i = 1; i < length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		int total = 0;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length; right++) {
				int subArrayLength = right - left + 1;
				if (subArrayLength % 2 != 0) {
					int sum;
					if (left == 0) {
						sum = prefix[right];
					} else {
						sum = prefix[right] - prefix[left - 1];
					}
					total = total + sum;
				}
			}
		}
		System.out.println(total);
	}
}
