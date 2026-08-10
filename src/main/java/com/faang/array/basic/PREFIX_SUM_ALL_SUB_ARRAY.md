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

``` java
for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {
        // Current subarray:
        // arr[left ... right]
    }
}
```

Remember:

``` text
left  = starting index
right = ending index
```

------------------------------------------------------------------------

## Template 2 --- Find Subarray Length

``` java
int subArrayLength = right - left + 1;
```

Formula:

``` text
Subarray Length = right - left + 1
```

Common conditions:

``` java
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
```

------------------------------------------------------------------------

## Template 3 --- Build Prefix Sum

``` java
int[] prefix = new int[length];

prefix[0] = arr[0];

for (int i = 1; i < length; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
}
```

Meaning:

``` text
prefix[i] = sum from arr[0] through arr[i]
```

Example:

``` text
arr    = [1, 4, 2, 5, 3]
prefix = [1, 5, 7, 12, 15]
```

------------------------------------------------------------------------

## Template 4 --- Find Sum of Any Subarray

``` java
int sum;

if (left == 0) {
    sum = prefix[right];
} else {
    sum = prefix[right] - prefix[left - 1];
}
```

Formula:

``` text
left == 0
sum = prefix[right]

otherwise
sum = prefix[right] - prefix[left - 1]
```

------------------------------------------------------------------------

## Template 5 --- Sum All Subarray Sums

``` java
int total = 0;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int sum;

        if (left == 0) {
            sum = prefix[right];
        } else {
            sum = prefix[right] - prefix[left - 1];
        }

        total = total + sum;
    }
}
```

------------------------------------------------------------------------

## Template 6 --- Count Subarrays Satisfying a Condition

``` java
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
```

Generic pattern:

``` java
if (condition) {
    count++;
}
```

------------------------------------------------------------------------

## Template 7 --- Find Maximum Subarray Sum Using Enumeration

``` java
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
```

Pattern:

``` text
All Subarrays
+
Prefix Sum
+
First Largest Element
```

For the standard maximum-subarray problem, Kadane's algorithm is faster.

------------------------------------------------------------------------

## Template 8 --- Find Minimum Subarray Sum

``` java
int firstSmallest = Integer.MAX_VALUE;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int sum;

        if (left == 0) {
            sum = prefix[right];
        } else {
            sum = prefix[right] - prefix[left - 1];
        }

        if (sum < firstSmallest) {
            firstSmallest = sum;
        }
    }
}
```

Pattern:

``` text
All Subarrays
+
Prefix Sum
+
First Smallest Element
```

------------------------------------------------------------------------

## Template 9 --- Odd-Length Subarrays

``` java
int total = 0;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int subArrayLength = right - left + 1;

        if (subArrayLength % 2 != 0) {

            int sum;

            if (left == 0) {
                sum = prefix[right];
            } else {
                sum = prefix[right] - prefix[left - 1];
            }

            total = total + sum;
        }
    }
}
```

Pattern:

``` text
Generate subarray
      ↓
Find length
      ↓
Is length odd?
      ↓
Find range sum
      ↓
Add to total
```

------------------------------------------------------------------------

## Template 10 --- Even-Length Subarrays

``` java
if (subArrayLength % 2 == 0) {

    int sum;

    if (left == 0) {
        sum = prefix[right];
    } else {
        sum = prefix[right] - prefix[left - 1];
    }

    total = total + sum;
}
```

Remember:

``` text
Odd  = length % 2 != 0
Even = length % 2 == 0
```

------------------------------------------------------------------------

## Template 11 --- Subarrays of Exactly Length K

Formula:

``` text
length = right - left + 1

k = right - left + 1

right = left + k - 1
```

Template:

``` java
for (int left = 0; left + k <= length; left++) {

    int right = left + k - 1;

    int sum;

    if (left == 0) {
        sum = prefix[right];
    } else {
        sum = prefix[right] - prefix[left - 1];
    }
}
```

This leads naturally into the **Sliding Window** pattern.

------------------------------------------------------------------------

## Template 12 --- Count Subarrays Where Sum Equals K

``` java
int count = 0;

for (int left = 0; left < length; left++) {
    for (int right = left; right < length; right++) {

        int sum;

        if (left == 0) {
            sum = prefix[right];
        } else {
            sum = prefix[right] - prefix[left - 1];
        }

        if (sum == k) {
            count++;
        }
    }
}
```

A faster pattern to learn later is:

``` text
Prefix Sum + HashMap
```

------------------------------------------------------------------------

## Template 13 --- Generic All-Subarray Template

``` java
package com.faang.array.basic;

public class _07_03_AllSubArrays {

    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 5, 3};
        int length = arr.length;

        // =========================
        // Step 1: Prefix Sum
        // =========================

        int[] prefix = new int[length];

        prefix[0] = arr[0];

        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // =========================
        // Step 2: All Subarrays
        // =========================

        for (int left = 0; left < length; left++) {
            for (int right = left; right < length; right++) {

                // =========================
                // Step 3: Subarray Length
                // =========================

                int subArrayLength = right - left + 1;

                // =========================
                // Step 4: Subarray Sum
                // =========================

                int sum;

                if (left == 0) {
                    sum = prefix[right];
                } else {
                    sum = prefix[right] - prefix[left - 1];
                }

                // =========================
                // Step 5: Problem Condition
                // =========================

                // if (subArrayLength % 2 != 0)
                // if (subArrayLength % 2 == 0)
                // if (subArrayLength == k)
                // if (sum == k)
                // if (sum > k)
                // if (sum < k)

                // =========================
                // Step 6: Problem Action
                // =========================

                // count++;
                // total = total + sum;
                // find maximum
                // find minimum
            }
        }
    }
}
```

------------------------------------------------------------------------

# Mental Framework

``` text
                ALL SUBARRAY PROBLEM
                        |
                        v
              Do I need range sums?
                   /         \
                 YES          NO
                  |
             Prefix Sum
                  |
                  v
        Choose LEFT and RIGHT
                  |
                  v
       length = right-left+1
                  |
                  v
          Calculate range sum
                  |
                  v
          Apply CONDITION
                  |
                  v
              ACTION
        /         |          \
       v          v           v
     count      total      max/min
```

------------------------------------------------------------------------

# Important Patterns to Keep Separate

``` text
All Subarrays
→ two loops: left + right

Prefix Sum
→ cumulative sums

Range Sum
→ prefix[right] - prefix[left - 1]

Subarray Length
→ right - left + 1

Filtering
→ odd / even / sum == k / etc.

Aggregation
→ count / total / maximum / minimum
```

------------------------------------------------------------------------

# int vs long

When building prefix sums, check the constraints.

``` text
int  → about ±2 × 10^9
long → about ±9 × 10^18
```

If:

``` text
nums.length <= N
nums[i] <= M
```

estimate:

``` text
Maximum possible sum ≈ N × M
```

Example:

``` text
N = 10^5
M = 10^5

Maximum sum
= 10^5 × 10^5
= 10^10
```

Since:

``` text
10^10 > 2 × 10^9
```

use:

``` java
long[] prefix;
long sum;
long total;
```

Rule:

``` text
Possible result <= about 2 billion → int
Possible result >  about 2 billion → long
```

Always check the size of the calculation, not only one input element.

------------------------------------------------------------------------

# Quick Cheat Sheet

``` text
ALL SUBARRAYS
for left
    for right

SUBARRAY LENGTH
right - left + 1

PREFIX SUM
prefix[i] = prefix[i - 1] + arr[i]

RANGE SUM
prefix[right] - prefix[left - 1]

LEFT == 0 RANGE
prefix[right]

ODD LENGTH
length % 2 != 0

EVEN LENGTH
length % 2 == 0

EXACT LENGTH K
length == k

FIXED K RIGHT INDEX
right = left + k - 1

COUNT
count++

TOTAL
total = total + sum

MAXIMUM
if (sum > firstLargest)
    firstLargest = sum;

MINIMUM
if (sum < firstSmallest)
    firstSmallest = sum;

PREFIX SUM TYPE CHECK
maxLength × maxValue > 2 × 10^9
→ use long
```
