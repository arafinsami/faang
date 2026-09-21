# Sliding Window Maximum using Monotonic Deque

The deque stores **array indices** instead of array values.

The values corresponding to the indices in the deque are maintained in **decreasing order**.

Therefore, the index at the **front of the deque always represents the maximum value** of the current window.

---

## Algorithm

For every index `i` from `0` to `n - 1`:

### Step 1: Remove Expired Indices

Calculate the starting index of the current window:

```text
windowStart = i - k + 1
```

If the index at the front of the deque is smaller than `windowStart`, it is outside the current window.

```text
deque.peekFirst() < (i - k + 1)
```

Remove it from the front.

```text
while deque is not empty
      AND deque.peekFirst() < (i - k + 1)

      removeFirst()
```

---

### Step 2: Remove Smaller Elements

Compare the current element with the element represented by the index at the back of the deque.

```text
array[deque.peekLast()] < array[i]
```

While the back element is smaller than the current element, remove it.

```text
while deque is not empty
      AND array[deque.peekLast()] < array[i]

      removeLast()
```

These smaller elements can be removed because the current element is:

* larger than them, and
* appears later in the array.

Therefore, they cannot become the maximum of the current or any future window containing the current element.

---

### Step 3: Add Current Index

Add the current index `i` to the back of the deque.

```text
deque.addLast(i)
```

Because smaller elements were already removed, the values represented by the deque remain in decreasing order.

```text
FRONT                     BACK

largest → ... → smallest
```

---

### Step 4: Store the Maximum

A complete window of size `k` is formed when:

```text
i >= k - 1
```

The index at the front of the deque represents the maximum value.

```text
maximum = array[deque.peekFirst()]
```

Add it to the result.

---

## Algorithm Pseudocode

```text
result = []
deque = []

for i = 0 to n - 1:

    windowStart = i - k + 1

    // Step 1: Remove expired indices
    while deque is not empty
          AND deque.peekFirst() < windowStart:

        deque.removeFirst()

    // Step 2: Remove smaller elements
    while deque is not empty
          AND array[deque.peekLast()] < array[i]:

        deque.removeLast()

    // Step 3: Add current index
    deque.addLast(i)

    // Step 4: Store maximum
    if i >= k - 1:

        result.add(array[deque.peekFirst()])

return result
```

---

# Example

```text
array = [1, 4, 2, 5]

index =  0  1  2  3

k = 2
```

For every index:

```text
windowStart = i - k + 1
```

Since:

```text
k = 2

k - 1 = 1
```

the first complete window is formed when:

```text
i >= 1
```

---

# Explanation / Calculation

## i = 0

Current value:

```text
array[0] = 1
```

### Step 1: Calculate Window Start

```text
windowStart = i - k + 1

            = 0 - 2 + 1

            = -1
```

Deque before:

```text
[]
```

The deque is empty, so there is no expired index.

### Step 2: Remove Smaller Elements

The deque is empty, so there is nothing to compare.

### Step 3: Add Current Index

Add index `0`.

```text
indices = [0]

values  = [1]
```

### Step 4: Check Window

```text
i >= k - 1

0 >= 1 → false
```

The first window is not formed yet.

```text
Result = []
```

---

# i = 1

Current value:

```text
array[1] = 4
```

Deque before:

```text
indices = [0]

values  = [1]
```

### Step 1: Calculate Window Start

```text
windowStart = 1 - 2 + 1

            = 0
```

Check whether index `0` is expired:

```text
0 < 0 → false
```

Index `0` is still inside the current window.

### Step 2: Remove Smaller Elements

Compare the last deque value with the current value:

```text
array[deque.peekLast()] < array[i]

array[0] < array[1]

1 < 4 → true
```

Remove index `0`.

```text
indices = []

values  = []
```

### Step 3: Add Current Index

Add index `1`.

```text
indices = [1]

values  = [4]
```

### Step 4: Check Window

```text
i >= k - 1

1 >= 1 → true
```

The window is:

```text
[1, 4]
```

The maximum is:

```text
array[deque.peekFirst()]

= array[1]

= 4
```

Therefore:

```text
Result = [4]
```

---

# i = 2

Current value:

```text
array[2] = 2
```

Deque before:

```text
indices = [1]

values  = [4]
```

### Step 1: Calculate Window Start

```text
windowStart = 2 - 2 + 1

            = 1
```

Check whether index `1` is expired:

```text
1 < 1 → false
```

Index `1` is still inside the current window.

### Step 2: Remove Smaller Elements

```text
array[deque.peekLast()] < array[i]

array[1] < array[2]

4 < 2 → false
```

Nothing is removed.

### Step 3: Add Current Index

Add index `2`.

```text
indices = [1, 2]

values  = [4, 2]
```

Notice that the deque values are in decreasing order:

```text
4 > 2
```

### Step 4: Check Window

```text
i >= k - 1

2 >= 1 → true
```

Current window:

```text
[4, 2]
```

Maximum:

```text
array[deque.peekFirst()]

= array[1]

= 4
```

Therefore:

```text
Result = [4, 4]
```

---

# i = 3

Current value:

```text
array[3] = 5
```

Deque before:

```text
indices = [1, 2]

values  = [4, 2]
```

### Step 1: Calculate Window Start

```text
windowStart = 3 - 2 + 1

            = 2
```

Check the front index:

```text
deque.peekFirst() = 1
```

Check whether it is expired:

```text
1 < 2 → true
```

Index `1` is outside the current window.

Remove index `1`.

```text
indices = [2]

values  = [2]
```

### Step 2: Remove Smaller Elements

Compare:

```text
array[deque.peekLast()] < array[i]

array[2] < array[3]

2 < 5 → true
```

Remove index `2`.

```text
indices = []

values  = []
```

### Step 3: Add Current Index

Add index `3`.

```text
indices = [3]

values  = [5]
```

### Step 4: Check Window

```text
i >= k - 1

3 >= 1 → true
```

Current window:

```text
[2, 5]
```

Maximum:

```text
array[deque.peekFirst()]

= array[3]

= 5
```

Therefore:

```text
Result = [4, 4, 5]
```

---

# Calculation Summary

```text
i = 0

windowStart = 0 - 2 + 1 = -1

deque:
indices = [0]
values  = [1]

0 >= 1 → false

No output
```

```text
i = 1

windowStart = 1 - 2 + 1 = 0

0 < 0 → false

1 < 4 → remove index 0

deque:
indices = [1]
values  = [4]

1 >= 1 → true

maximum = array[1] = 4

Result = [4]
```

```text
i = 2

windowStart = 2 - 2 + 1 = 1

1 < 1 → false

4 < 2 → false

deque:
indices = [1, 2]
values  = [4, 2]

2 >= 1 → true

maximum = array[1] = 4

Result = [4, 4]
```

```text
i = 3

windowStart = 3 - 2 + 1 = 2

1 < 2 → index 1 expired

2 < 5 → remove index 2

deque:
indices = [3]
values  = [5]

3 >= 1 → true

maximum = array[3] = 5

Result = [4, 4, 5]
```

---

# Final Result

```text
Window [1, 4] → Maximum = 4

Window [4, 2] → Maximum = 4

Window [2, 5] → Maximum = 5
```

Therefore:

```text
Result = [4, 4, 5]
```

---

# Deque Invariant

The values represented by the deque are always maintained in decreasing order.

```text
FRONT                         BACK

largest → ................. → smallest
```

Therefore:

```text
deque.peekFirst()
```

always contains the **index of the maximum element** of the current window.

For example:

```text
indices = [1, 2]

values  = [4, 2]
```

Since:

```text
4 > 2
```

the front index `1` represents the maximum value:

```text
array[1] = 4
```

---

# Time Complexity

Each index is added to the deque exactly once.

```text
Maximum additions = n
```

Each index can also be removed at most once.

```text
Maximum removals = n
```

Therefore, the total number of deque operations is at most proportional to:

```text
n + n = 2n
```

Ignoring the constant:

```text
O(2n) = O(n)
```

So:

```text
Time Complexity = O(n)
```

Even though the algorithm contains `while` loops, the same index is not repeatedly added and removed. Across the entire algorithm, every index enters the deque once and leaves it at most once.

---

# Space Complexity

The deque only stores indices that are useful for the current sliding window.

The maximum window size is:

```text
k
```

Therefore, the deque can contain at most `k` indices.

```text
Space Complexity = O(k)
```

---

# Complexity Summary

```text
Time Complexity  = O(n)

Space Complexity = O(k)
```
