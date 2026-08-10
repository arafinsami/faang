package com.faang.array.basic;

public class _07_08_Prefix_Sum_SubArray_Templete4 {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2 };
        int length = arr.length;
        int[] prefix = new int[length];
        prefix[0] = arr[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int left = 0; left < length; left++) {
            for (int right = left; right < length; right++) {
                int sum = 0;
                if (left == 0) {
                    sum = prefix[right];
                } else {
                    sum = prefix[right] - prefix[left - 1];
                }
                System.out.println(
	                        "left = " + left +
	                        ", right = " + right +
	                        ", sum = " + sum);
            }
        }
    }
}
