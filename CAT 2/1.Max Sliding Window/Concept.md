# Max Sliding Window (Brute Force)

## What this code does
- Computes the maximum value in every sliding window of size `k` across an array `nums`.
- For each window position `i` from `0` to `n-k`, it scans subarray `nums[i..i+k-1]` to find max.

## Approach
- Check edge conditions (null or empty input).
- Initialize `result` size `n-k+1`.
- For each window start `i`:
  - Set `max` to `Integer.MIN_VALUE`.
  - Loop `j` from `i` to `i+k-1`, update `max = Math.max(max, nums[j])`.
  - Store `max` in `result[i]`.

## Complexity
- Time: O(n*k)
- Space: O(n)

## Dry run example
Input: nums=[1,3,-1,-3,5,3,6,7], k=3
Windows:
- [1,3,-1] -> max=3
- [3,-1,-3] -> max=3
- [-1,-3,5] -> max=5
- [-3,5,3] -> max=5
- [5,3,6] -> max=6
- [3,6,7] -> max=7
Output: [3,3,5,5,6,7]

## Main function
- Creates sample array/`k`, computes output, prints values.