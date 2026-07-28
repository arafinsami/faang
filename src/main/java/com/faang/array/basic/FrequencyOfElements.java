package com.faang.array.basic;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 7, 7, 9, 9, 7, 1 };
		int length = array.length;
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			frequency.put(array[i], frequency.getOrDefault(array[i], 0) + 1);
		}
		System.out.println(frequency);
	}
}
