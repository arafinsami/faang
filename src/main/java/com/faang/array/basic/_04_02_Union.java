package com.faang.array.basic;

import java.util.HashSet;
import java.util.Set;

public class _04_02_Union {
	public static void main(String[] args) {
		int[] array1 = { 1, 3, 5 };
		int[] array2 = { 2, 4, 6 };
		Set<Integer> union = new HashSet<Integer>();
		for (Integer num : array1) {
			union.add(num);
		}
		for (Integer num : array2) {
			union.add(num);
		}
		System.out.println(union);
	}
}
