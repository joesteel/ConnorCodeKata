package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UglyNumberTest {

    @Test
    void OneIsUgly() {
        assertTrue(UglyNumber.isUgly(1));
    }

    @Test
    void FourteenIsNotUgly() {
        assertFalse(UglyNumber.isUgly(14));
    }
}