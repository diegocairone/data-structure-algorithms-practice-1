package com.cairone.dsa.arrays.exercise1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays
 * whose sum equals to k.
 * <p>
 * Example: [2, 3, -5, 5, -5, 1, 4] with k=5
 * Sum:     [1, 5,  0, 5,  0, 1, 4]
 * Map:     {1=1, 2=1, 3=1, -5=2, 4=1, 5=1}
 * <p>
 * How does it work?
 * <p>
 * 1. We keep a running sum of the elements as we iterate through the array.<p>
 * 2. For each element, we calculate the difference between the current sum and k.<p>
 * 3. We check if this difference has been seen before (i.e., if it
 *   exists in our map). If it has, it means there is a subarray
 *   that sums to k, and we add the count of how many times
 *   this difference has been seen to our result count.<p>
 *   4. We then update our map with the current sum, incrementing its count.<p>
 *   This way, we efficiently track all possible subarrays that sum to k in a single pass through the array.
 *
 *   @author Diego Cairone
 */
@Slf4j
public class Exercise1 {

    private Exercise1() {
    }

    public static int subArraySum(int[] array, int k) {

        int currentSum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            currentSum += currentNum;

            // Previous sum is the current sum minus k
            // because sum(now) - sum(previous) = k  => sum(previous) = sum(now) - k
            int previousSum = currentSum - k;

            // Does the map contain the previous sum?
            // If so, then there is a subarray ending at index i which sums to k
            if (map.containsKey(previousSum)) {
                count += map.get(previousSum);
            }

            // Add to the map the current sum for each iteration
            // This will help to know how many times this sum has appeared
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        log.info("Map: {}", map);

        return count;
    }
}
