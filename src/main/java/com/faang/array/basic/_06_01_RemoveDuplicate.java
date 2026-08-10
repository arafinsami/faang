package com.faang.array.basic;

import java.util.Arrays;

public class _06_01_RemoveDuplicate {
	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 2, 2, 7, 7, 9, 9, 7 };
		int length = array.length;
		Arrays.sort(array);
		int j = 0;
		for (int i = 1; i < length; i++) {
			if (array[i] != array[j]) {
				j++;
				array[j] = array[i];
			}
		}

		for (int i = 0; i <= j; i++) {
			System.out.println(array[i]);
		}
	}
}
