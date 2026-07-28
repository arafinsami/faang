package com.faang.array.basic;

public class CheckArrayIsSorted {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 4, 9, 7, 6 };
		int length = arr.length;
		boolean isSorted = true;
		for (int i = 0; i < length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				isSorted = false;
				break;
			}
		}
		System.out.println(isSorted ? "array sorted" : "not sorted");
	}
}