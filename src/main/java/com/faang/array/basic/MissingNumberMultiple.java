package com.faang.array.basic;

public class MissingNumberMultiple {
	public static void main(String[] args) {
		int[] array = { 1, 4 };
		int length = array.length;
		int n = 4;
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < length; i++) {
			visited[array[i]] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				System.out.println(i);
			}
		}
	}
}
