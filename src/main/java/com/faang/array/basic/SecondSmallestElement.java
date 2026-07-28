package com.faang.array.basic;

public class SecondSmallestElement {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int length = array.length;
		int firstSmallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			if (array[i] < firstSmallest) {
				firstSmallest = array[i];
			}
		}

		for (int i = 0; i < length; i++) {
			if (array[i] < secondSmallest && array[i] != firstSmallest) {
				secondSmallest = array[i];
			}
		}

		System.out.println(firstSmallest);
		System.out.println(secondSmallest);
	}
}
