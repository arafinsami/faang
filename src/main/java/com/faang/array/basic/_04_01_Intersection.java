package com.faang.array.basic;

import java.util.HashSet;
import java.util.Set;

public class _04_01_Intersection {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 2 };
		Set<Integer> intersection = new HashSet<Integer>();
		for (Integer num : array1) {
			intersection.add(num);
		}
		for (Integer num : array2) {
			if (intersection.contains(num)) {
				System.out.println(num);
			}
		}
	}
}
