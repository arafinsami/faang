package com.faang.array.basic;

public class FirstLargestElement {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int length = array.length;
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		}
		System.out.println(largest);
	}
}
