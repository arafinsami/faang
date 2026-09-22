package com.faang.array.sliding.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Subarray With Sum Exactly Equal To Target
 *
 * Mental Model:
 * EXPAND -> SHRINK IF TOO LARGE -> CHECK EXACT -> UPDATE MAX
 *
 * <pre>
 * EXPAND
 *    ↓
 * TOO LARGE?
 *    ↓ yes
 * SHRINK
 *    ↓
 * EXACT TARGET?
 *    ↓ yes
 * UPDATE MAX
 * </pre>
 *
 * Pattern:
 *
 * <pre>
 * for (right pointer) {
 *     add right element to sum
 *
 *     while (sum > target) {
 *         remove left element from sum
 *         move left pointer
 *     }
 *
 *     if (sum == target) {
 *         calculate window length
 *
 *         if (window is longer than best) {
 *             update max length
 *             save window
 *         }
 *     }
 * }
 * </pre>
 *
 * Key Idea:
 * - Expand the window by moving right.
 * - If sum becomes too large, shrink from left.
 * - When sum is exactly target, compare with the longest answer.
 *
 * Works when array elements are non-negative.
 *
 * Time:  O(n)
 * Space: O(1), excluding saved result
 */
public class _1_1_LongestSubarraySumExactlyTarget {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int length = array.length;
		int target = 9;
		int leftIndex = 0;
		int currentSum = 0;
		int maxLength = 0;
		List<Integer> bestWindow = new ArrayList<>();
		for (int rightIndex = 0; rightIndex < length; rightIndex++) {
			currentSum = currentSum + array[rightIndex];
			while (currentSum > target && leftIndex <= rightIndex) {
				currentSum = currentSum - array[leftIndex];
				leftIndex++;
			}
			if (currentSum == target) {
				int windowLength = rightIndex - leftIndex + 1;
				if (windowLength > maxLength) {
					maxLength = windowLength;
					bestWindow = buildWindow(array, leftIndex, rightIndex);
				}
			}
		}
		System.out.println(bestWindow);
	}

	private static List<Integer> buildWindow(int[] array, int leftIndex, int rightIndex) {
		List<Integer> window = new ArrayList<Integer>();
		for (int index = leftIndex; index <= rightIndex; index++) {
			window.add(array[index]);
		}
		return window;
	}
}
