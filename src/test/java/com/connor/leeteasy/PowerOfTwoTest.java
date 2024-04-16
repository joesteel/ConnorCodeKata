package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTest {

    @Test
    void shouldReturnFalseFor0() {
        assertFalse(PowerOfTwo.isPowerOfTwo(0));
    }
    @Test
    void shouldReturnTrueFor16() {
        assertTrue(PowerOfTwo.isPowerOfTwo(16));
    }
    @Test
    void shouldReturnFalseFor3() {
        assertFalse(PowerOfTwo.isPowerOfTwo(3));
    }

    @Test
    void shouldReturnFalseForNegative4() {
        assertFalse(PowerOfTwo.isPowerOfTwo(-4));
    }
}