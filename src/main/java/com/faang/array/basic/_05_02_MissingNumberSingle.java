package com.faang.array.basic;

public class _05_02_MissingNumberSingle {
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 5 };
		int length = array.length;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += array[i];
		}
		int n = length + 1;
		n = n * (n + 1) / 2;
		int missingNumber = n - sum;
		System.out.println(missingNumber);
	}
}
