package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectNumberTest {

    @Test
    void shouldDetectPerfectNumber() {
        assertFalse(PerfectNumber.checkPerfectNumber(1));
        assertTrue(PerfectNumber.checkPerfectNumber(6));
        assertFalse(PerfectNumber.checkPerfectNumber(3));
        assertFalse(PerfectNumber.checkPerfectNumber(7));
        assertTrue(PerfectNumber.checkPerfectNumber(28));
    }
}