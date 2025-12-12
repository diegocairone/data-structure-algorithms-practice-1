package com.cairone.dsa.binarysearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exercise1 {

    private Exercise1() { }

    public static int[] searchRange(int[] array, int target) {
        if (array == null || array.length == 0) {
            return new int[] {-1, -1};
        }

        int startingIdx = findIdx(array, target, true);
        int endingIdx = findIdx(array, target, false);

        return new int[] {startingIdx, endingIdx};
    }

    public static int findIdx(int[] array, int target, boolean isStartingIdx) {

        int lowIdx = 0;
        int highIdx = array.length - 1;

        int result = -1;

        while(lowIdx <= highIdx) {

            int midIdx = lowIdx + (highIdx - lowIdx) / 2;

            if (array[midIdx] == target) {
                result = midIdx;
                if (isStartingIdx) {
                    highIdx = midIdx - 1;
                } else {
                    lowIdx = midIdx + 1;
                }
            } else if (array[midIdx] > target) {
                highIdx = midIdx - 1;
            } else if (array[midIdx] < target) {
                lowIdx = midIdx + 1;
            }
        }

        return result;
    }
}
