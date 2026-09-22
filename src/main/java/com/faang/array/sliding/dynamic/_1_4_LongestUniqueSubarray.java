package com.faang.array.sliding.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Subarray With Unique Elements
 *
 * Mental Model:
 * EXPAND -> CHECK DUPLICATE -> SHRINK UNTIL UNIQUE -> ADD -> UPDATE MAX
 *
 * <pre>
 * EXPAND
 *    ↓
 * DUPLICATE?
 *    ↓ yes
 * SHRINK
 *    ↓
 * STILL DUPLICATE?
 *    ↓ no
 * ADD RIGHT ELEMENT
 *    ↓
 * UPDATE MAX
 * </pre>
 *
 * Pattern:
 *
 * <pre>
 * for (right pointer) {
 *
 *     while (right element already exists in window) {
 *         remove left element from seen
 *         move left pointer
 *     }
 *
 *     add right element to seen
 *
 *     calculate window length
 *
 *     if (window is longer than best) {
 *         update max length
 *         save window
 *     }
 * }
 * </pre>
 *
 * Key Idea:
 * - Expand the window by moving right.
 * - If the right element already exists, the window would contain a duplicate.
 * - Shrink from left until the duplicate is removed.
 * - Add the right element after the window becomes unique.
 * - Compare the valid unique window with the longest answer.
 *
 * The boolean[] approach requires array values to be valid indexes
 * within the seen array (0 to 255 in this implementation).
 * For arbitrary integers, use a HashSet instead.
 *
 * Time:  O(n)
 * Space: O(1) for the fixed-size seen array, excluding saved result
 */
public class _1_4_LongestUniqueSubarray {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int length = array.length;
		int leftIndex = 0;
		int maxLength = 0;
		boolean[] seen = new boolean[256];
		List<Integer> bestWindow = new ArrayList<>();
		for (int rightIndex = 0; rightIndex < length; rightIndex++) {
			while (seen[array[rightIndex]]) {
				seen[array[leftIndex]] = false;
				leftIndex++;
			}
			seen[array[rightIndex]] = true;
			int windowLength = rightIndex - leftIndex + 1;
			if (windowLength > maxLength) {
				maxLength = windowLength;
				bestWindow = buildWindow(array, leftIndex, rightIndex);
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
