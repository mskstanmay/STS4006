# Heap Sort

## What this folder should contain
- An implementation of Heap Sort (build max heap, repeatedly extract max, heapify) is expected here.
- Currently folder may be empty; this document explains the approach.

## Heap Sort algorithm
1. Build max heap from input array (O(n)).
2. For `i = n-1` down to `1`:
   - Swap `arr[0]` (max) with `arr[i]`.
   - Reduce heap size by 1.
   - Heapify root (O(log n)).

## Complexity
- Time: O(n log n)
- Space: O(1) in-place

## Dry run example
Input: [4,10,3,5,1]
- Build max heap: [10,5,3,4,1]
- Swap 10 and 1: [1,5,3,4,10], heapify -> [5,4,3,1,10]
- Swap 5 and 1: [1,4,3,5,10], heapify -> [4,1,3,5,10]
- Swap 4 and 3: [3,1,4,5,10], heapify -> [3,1,4,5,10]
- Continue until sorted: [1,3,4,5,10]

## Note
- Add Java code in this folder under `HeapSort.java` if you want an actual implementation.