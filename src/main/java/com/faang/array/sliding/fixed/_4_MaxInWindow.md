# Sliding Window Maximum using Monotonic Deque

The deque stores array indices instead of array values

Values corresponding to the indices are maintained in decreasing order

The front of the deque always represents the maximum value

## Algorithm

### Step 1

Remove indices that are outside the current window

If `front_index < (i - k + 1)`, it is expired

### Step 2

`array[deque.peekLast()] < array[i]`

Remove elements smaller than the current element

They cannot be maximum in this or future windows

### Step 3

Add current index to deque

### Step 4

Check if `i >= k - 1`

Once window is formed, front of deque is the maximum
------------------------------------------------------------------------
## Example

``` text
array = [1, 4, 2, 5]
index =  0  1  2  3
k = 2
```

## Iteration Details

### i = 0

``` text
Current value: 1

Deque before: []

Add index 0

Deque: [0]
Values: [1]

No window yet
```
------------------------------------------------------------------------
### i = 1

``` text
Current value: 4

Deque before:
indices [0]
values  [1]

1 < 4 → remove index 0

Add index 1

indices [1]
values  [4]

Window: [1, 4]
Maximum: 4

Result: [4]
```
------------------------------------------------------------------------
### i = 2

``` text
Current value: 2

Deque before:
indices [1]
values  [4]

Index 1 is not expired
4 < 2 → false

Add index 2

indices [1, 2]
values  [4, 2]

Window: [4, 2]
Maximum: 4

Result: [4, 4]
```
------------------------------------------------------------------------
### i = 3

``` text
Current value: 5

Deque before:
indices [1, 2]
values  [4, 2]

Window starts at index 2

1 < 2 → index 1 expired
Remove index 1

indices [2]
values  [2]

2 < 5 → remove index 2

indices []
values  []

Add index 3

indices [3]
values  [5]

Window: [2, 5]
Maximum: 5

Result: [4, 4, 5]
```

------------------------------------------------------------------------
## Final Result

``` text
Window [1, 4] → Maximum 4
Window [4, 2] → Maximum 4
Window [2, 5] → Maximum 5

Result [4, 4, 5]
```
------------------------------------------------------------------------
## Deque Invariant

Deque values are always in decreasing order

``` text
FRONT                     BACK
largest → ... → smallest
```

`deque.peekFirst()` always contains the index of the maximum value

Each index is added once

Each index is removed at most once

**Time Complexity** `O(n)`

**Space Complexity** `O(k)`
