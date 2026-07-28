package com.faang.array.basic;

public class LeftRotate_Method_1 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int arrayLength = array.length;
		int k = 3;
		k = k % arrayLength;
		int index = 0;
		int[] tempArray = new int[arrayLength];
		for (int i = k; i < arrayLength; i++) {
			tempArray[index] = array[i];
			index++;
		}
		for (int i = 0; i < k; i++) {
			tempArray[index] = array[i];
			index++;
		}
		for (int i = 0; i < arrayLength; i++) {
			System.out.println(tempArray[i]);
		}
	}
}
