package com.cairone.dsa.arrays.exercise1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise1Test {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void subArraySum(int[] array, int k, int count) {
        int result = Exercise1.subArraySum(array, k);
        Assertions.assertThat(result).isEqualTo(count);
    }

    static Object[][] arrayProvider() {
        return new Object[][] {
                { new int[] {2, 3, -5, 5, -5, 1, 4}, 5, 6 },
                { new int[] {1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3, 8 }
        };
    }
}