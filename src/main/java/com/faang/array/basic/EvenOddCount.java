package com.faang.array.basic;

public class EvenOddCount {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int length = array.length;
		int evenCounter = 0;
		int oddCounter = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] % 2 == 0) {
				evenCounter++;
			} else {
				oddCounter++;
			}
		}
		System.out.println(evenCounter);
		System.out.println(oddCounter);
	}
}
