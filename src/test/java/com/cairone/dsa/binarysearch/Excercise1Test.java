package com.cairone.dsa.binarysearch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Excercise1Test {

    @ParameterizedTest
    @MethodSource("argsProvider")
    void searchRange(int[] array, int target, int[] expected) {
        int[] result = Exercise1.searchRange(array, target);
        Assertions.assertThat(result).containsExactly(expected);
    }

    static Object[][] argsProvider() {
        return new Object[][] {
                { null, 0, new int[] {-1, -1} },
                { new int[] {2, 3, 3, 4, 7, 8, 8, 8, 10, 12, 12}, 8, new int[] {5, 7} }
        };
    }
}