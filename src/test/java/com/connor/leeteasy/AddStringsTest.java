package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {

    @Test
    void shouldAddSingleDigitsNoCarry() {
        String result = AddStrings.addStrings("0", "1");
        assertEquals("1", result);
    }

    @Test
    void shouldAddMultiDigitsNoCarry() {
        String result = AddStrings.addStrings("11", "11");
        assertEquals("22", result);
    }

    @Test
    void shouldAddMultiDigitsDifferentLengthsNoCarry() {
        String result = AddStrings.addStrings("111", "11");
        assertEquals("122", result);
    }
    @Test
    void shouldAddSingleDigitsWithCarry() {
        String result = AddStrings.addStrings("9", "1");
        assertEquals("10", result);
    }
}