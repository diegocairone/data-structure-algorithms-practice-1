package com.cairone.dsa.sets;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstUnrepeatedCharInStringTest {

    @ParameterizedTest
    @CsvSource({
            "abacaba, 3",
            "aabbcdeee, 4",
            "dabc, 0",
            "aabbcc, -1"
    })
    void findUnrepeated(String value, int expected) {
        int result = FirstUnrepeatedCharInString.findUnrepeated(value);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}