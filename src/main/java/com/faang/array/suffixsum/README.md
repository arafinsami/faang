Definition: A suffix represents information from the CURRENT index
to the END of the array.

For index i:
    suffix = nums[i ... n - 1]

1. SUFFIX SUM

Meaning: Sum of all elements from index i to n - 1.

Formula: suffixSum[i] = nums[i] + suffixSum[i + 1]

Base Case: suffixSum[n - 1] = nums[n - 1]


Code Pattern:
    suffixSum[n - 1] = nums[n - 1]
    for i = n - 2 down to 0:
        suffixSum[i] = nums[i] + suffixSum[i + 1]


Example:
    nums = [2, 4, 1, 5]
    suffixSum[3] = 5
    suffixSum[2] = 1 + 5  = 6
    suffixSum[1] = 4 + 6  = 10
    suffixSum[0] = 2 + 10 = 12

    suffixSum = [12, 10, 6, 5]


2. SUFFIX MAXIMUM

Meaning: Maximum element from index i to n - 1.

Formula:
    suffixMax[i] = max(nums[i], suffixMax[i + 1])

Base Case: suffixMax[n - 1] = nums[n - 1]

Code Pattern: suffixMax[n - 1] = nums[n - 1]

    for i = n - 2 down to 0:
        suffixMax[i] = max(nums[i], suffixMax[i + 1])

Example:
    nums = [2, 7, 3, 5, 1]
    suffixMax = [7, 7, 5, 5, 1]

3. SUFFIX MINIMUM

Meaning: Minimum element from index i to n - 1.

Formula: suffixMin[i] = min(nums[i], suffixMin[i + 1])

Base Case: suffixMin[n - 1] = nums[n - 1]

Code Pattern:
    suffixMin[n - 1] = nums[n - 1]
    for i = n - 2 down to 0:
        suffixMin[i] = min(nums[i], suffixMin[i + 1])

Example:
    nums = [8, 4, 6, 2, 5]
    suffixMin = [2, 2, 2, 2, 5]

4. SUFFIX COUNT

Meaning: Count how many elements satisfying a condition exist
from index i to n - 1.


Formula: suffixCount[i] = condition(nums[i]) + suffixCount[i + 1]


Where:
    condition(nums[i]) = 1   if true
                         0   if false


Base Case: suffixCount[n - 1] = condition(nums[n - 1])


Code Pattern:
    suffixCount[n - 1] = condition(nums[n - 1])
    for i = n - 2 down to 0:
        suffixCount[i] =
            condition(nums[i]) + suffixCount[i + 1]


Example:
    nums = [1, 0, 1, 1, 0]
    condition:
        nums[i] == 1

    suffixCount = [3, 2, 2, 1, 0]

5. SUFFIX PRODUCT

Meaning: Product of all elements from index i to n - 1.

Formula: suffixProduct[i] = nums[i] * suffixProduct[i + 1]

Base Case: suffixProduct[n - 1] = nums[n - 1]


Code Pattern:
    suffixProduct[n - 1] = nums[n - 1]
    for i = n - 2 down to 0:
        suffixProduct[i] =
            nums[i] * suffixProduct[i + 1]


Example:
    nums = [2, 3, 4, 5]
    suffixProduct[3] = 5
    suffixProduct[2] = 4 * 5  = 20
    suffixProduct[1] = 3 * 20 = 60
    suffixProduct[0] = 2 * 60 = 120
    suffixProduct = [120, 60, 20, 5]



General Pattern:
    suffix[n - 1] = value(nums[n - 1])

    for i = n - 2 down to 0:

        suffix[i] = combine(nums[i], suffix[i + 1])


Change the combine operation depending on the problem:


Suffix Sum: suffix[i] = nums[i] + suffix[i + 1]


Suffix Maximum: suffix[i] = max(nums[i], suffix[i + 1])


Suffix Minimum: suffix[i] = min(nums[i], suffix[i + 1])


Suffix Count: suffix[i] = condition(nums[i]) + suffix[i + 1]


Suffix Product: suffix[i] = nums[i] * suffix[i + 1]



                     PREFIX VS SUFFIX


PREFIX:

    LEFT  ------------------------> RIGHT

    prefix[i] depends on prefix[i - 1]


SUFFIX:

    LEFT  <------------------------ RIGHT

    suffix[i] depends on suffix[i + 1]


Therefore:

    PREFIX  -> build LEFT to RIGHT

    SUFFIX  -> build RIGHT to LEFT



INTERVIEW THINKING

When we see:

    "elements to the right"

    "sum to the right"

    "sum after index i"

    "maximum on the right"

    "minimum on the right"

    "number of X on the right"

    "product of elements on the right"

    "information from i to n - 1"


Think: SUFFIX


Ask yourself:

    "Can I precompute information about everything
     to the RIGHT of each index?"



COMPLEXITY

Building a suffix array:

    Time  -> O(n)

    Space -> O(n)


If only the current suffix value is needed:

    Time        -> O(n)

    Extra Space -> O(1)



CORE IDEA

For Prefix:

    previous answer + current element
                     |
                     v
                 new answer


For Suffix:

    current element + answer to the right
                     |
                     v
                 new answer


General Formula:

    suffix[i] = combine(nums[i], suffix[i + 1])


Most important thing to remember:

                 SUFFIX = RIGHT TO LEFT