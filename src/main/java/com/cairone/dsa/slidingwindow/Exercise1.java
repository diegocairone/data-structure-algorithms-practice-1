package com.cairone.dsa.slidingwindow;

/**
 * Given an array of positive numbers <code>nums</code> and a positive number <code>k</code>,
 * find the maximum sum of any contiguous subarray of size <code>k</code>.
 * <br><br>
 * For example:
 * <br>
 * Input: nums = [2, 1, 5, 1, 3, 2], k = 3.
 * <br>
 * Output: 9
 */
public class Exercise1 {

    public int getSumOfSize(int[] array, int k) {

        int maxSum = 0;
        int currentSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            int elem = array[windowEnd];
            currentSum += elem;

            if (windowEnd + 1 > k) {
                currentSum -= array[windowStart];
                windowStart++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
