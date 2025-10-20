package com.connor.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class fibTest {

    @Test
    void shouldAddUpNumbers() {
        int expectedResult = 1;
        assertEquals(expectedResult, Fib.fib(1, new Integer[1]));
    }

    @Test
    void shouldAddUpNumbers5() {
        int expectedResult = 13;
        assertEquals(expectedResult, Fib.fib(7, new Integer[8]));
    }

}