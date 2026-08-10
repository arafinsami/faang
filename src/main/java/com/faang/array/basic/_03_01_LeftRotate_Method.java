package com.faang.array.basic;

public class _03_01_LeftRotate_Method {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int length = array.length;
		int k = 3;
		k = k % length;
		reverse(array, 0, k - 1);
		reverse(array, k, length - 1);
		reverse(array, 0, length - 1);
		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void reverse(int[] array, int startIndex, int endIndex) {
		while (startIndex < endIndex) {
			int tempValue = array[startIndex];
			array[startIndex] = array[endIndex];
			array[endIndex] = tempValue;
			startIndex++;
			endIndex--;
		}
	}
}
