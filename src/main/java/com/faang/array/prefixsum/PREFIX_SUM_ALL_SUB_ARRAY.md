# Java Array Patterns --- All Subarrays + Prefix Sum

This README contains reusable templates for solving array problems
involving:

-   All subarrays
-   Contiguous subarrays
-   Prefix sums
-   Range sums
-   Odd/even-length subarrays
-   Fixed-length subarrays
-   Counting subarrays
-   Maximum/minimum subarray values
-   Subarray conditions

------------------------------------------------------------------------
## Template 1 --- Generate All Subarrays by Indices

Use this whenever the problem says **all subarrays**, **contiguous
subarrays**, or asks you to inspect every possible `[left ... right]`.

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {
        // Current subarray:
        // arr[left ... right]
    }
}

Remember:
left  = starting index
right = ending index
------------------------------------------------------------------------
## Template 2 --- Find Subarray Length
int subArrayLength = right - left + 1;

Formula:
Subarray Length = right - left + 1

Common conditions:
// Odd length
if (subArrayLength % 2 != 0) {
}

// Even length
if (subArrayLength % 2 == 0) {
}

// Length exactly k
if (subArrayLength == k) {
}

// Length at least k
if (subArrayLength >= k) {
}

// Length at most k
if (subArrayLength <= k) {
}
------------------------------------------------------------------------
## Template 3 --- Build Prefix Sum
int[] prefix = new int[length];

prefix[0] = arr[0];

for (int i = 1; i < length; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
}

Meaning:
prefix[i] = sum from arr[0] through arr[i]


Example:
arr    = [1, 4, 2, 5, 3]
prefix = [1, 5, 7, 12, 15]
------------------------------------------------------------------------
## Template 4 --- Find Sum of Any Subarray

int sum;

if (left == 0) {
    sum = prefix[right];
} else {
    sum = prefix[right] - prefix[left - 1];
}

Formula:
left == 0
sum = prefix[right]

otherwise
sum = prefix[right] - prefix[left - 1]
------------------------------------------------------------------------

## Template 5 --- Count Subarrays Satisfying a Condition
int count = 0;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int sum;

        if (left == 0) {
            sum = prefix[right];
        } else {
            sum = prefix[right] - prefix[left - 1];
        }

        if (sum > k) {
            count++;
        }
    }
}
Generic pattern:
if (condition) {
    count++;
}
------------------------------------------------------------------------

## Template 6 --- Find Maximum Subarray Sum Using Enumeration

int firstLargest = Integer.MIN_VALUE;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int sum;

        if (left == 0) {
            sum = prefix[right];
        } else {
            sum = prefix[right] - prefix[left - 1];
        }

        if (sum > firstLargest) {
            firstLargest = sum;
        }
    }
}
Pattern:
All Subarrays
+
Prefix Sum
+
First Largest Element

For the standard maximum-subarray problem, Kadane's algorithm is faster.