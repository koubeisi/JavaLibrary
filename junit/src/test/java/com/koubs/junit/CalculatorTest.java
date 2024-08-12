package com.koubs.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author KouBeisi
 * @since 2021/9/7
 */
class CalculatorTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void addAndExpectedCvs(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("addMethodSourceParameterProvider")
    void addAndExpected(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    static Stream<Arguments> addMethodSourceParameterProvider() {
        return Stream.of(Arguments.arguments(0, 1, 1)
                , Arguments.arguments(1, 2, 3)
                , Arguments.arguments(49, 51, 100)
                , Arguments.arguments(1, 100, 101));
    }


    @ParameterizedTest
    @MethodSource("addMethodSourceProvider")
    void addAndExpected(int[] array) {
        int first = array[0];
        int second = array[1];
        int expectedResult = array[2];
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    static Stream<int[]> addMethodSourceProvider() {
        return Stream.of(new int[]{0, 1, 1}, new int[]{1, 2, 3}, new int[]{49, 51, 100}, new int[]{1, 100, 101});
    }
}
