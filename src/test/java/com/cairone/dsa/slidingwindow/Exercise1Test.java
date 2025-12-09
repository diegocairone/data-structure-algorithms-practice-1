package com.cairone.dsa.slidingwindow;

import org.assertj.core.api.AbstractSoftAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void getSumOfSize(int[] array, int k, int expected) {
        Exercise1 exercise1 = new Exercise1();
        int result = exercise1.getSumOfSize(array, k);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Object[][] arrayProvider() {
        return new Object[][] {
                { new int[] {2, 1, 5, 1, 3, 2}, 3, 9 }
        };
    }
}