package com.faang.array.sliding.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Shortest Subarray With Sum Greater Than Or Equal To Target
 *
 * Mental Model:
 * EXPAND -> CHECK VALID -> UPDATE MIN -> SHRINK WHILE VALID
 *
 * <pre>
 * EXPAND
 *    ↓
 * TARGET REACHED?
 *    ↓ yes
 * UPDATE MIN
 *    ↓
 * SHRINK
 *    ↓
 * STILL TARGET REACHED?
 *    ↓ yes
 * UPDATE MIN
 *    ↓
 * SHRINK
 * </pre>
 *
 * Pattern:
 *
 * <pre>
 * for (right pointer) {
 *     add right element to sum
 *
 *     while (sum >= target) {
 *         calculate window length
 *
 *         if (window is shorter than best) {
 *             update min length
 *             save window
 *         }
 *
 *         remove left element from sum
 *         move left pointer
 *     }
 * }
 * </pre>
 *
 * Key Idea:
 * - Expand the window by moving right.
 * - When sum becomes greater than or equal to target, the window is valid.
 * - Record the valid window before shrinking.
 * - Keep shrinking while the window remains valid.
 * - Compare each valid window with the shortest answer.
 *
 * Works when array elements are non-negative.
 *
 * Time:  O(n)
 * Space: O(1), excluding saved result
 */
public class _1_3_ShortestSumGreaterEqualTarget {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int length = array.length;
		int target = 9;
		int leftIndex = 0;
		int currentSum = 0;
		int minLength = Integer.MAX_VALUE;
		List<Integer> bestWindow = new ArrayList<>();
		for (int rightIndex = 0; rightIndex < length; rightIndex++) {
			currentSum = currentSum + array[rightIndex];
			while (currentSum >= target && leftIndex <= rightIndex) {
				int windowLength = rightIndex - leftIndex + 1;
				if (windowLength < minLength) {
					minLength = windowLength;
					bestWindow = buildWindow(array, leftIndex, rightIndex);
				}
				currentSum = currentSum - array[leftIndex];
				leftIndex++;
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
