package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountBinarySubstringsTest {

    @Test
    void shouldCountBinarySubstrings() {
        assertEquals(6, CountBinarySubstrings.countBinarySubstrings("00110011"));
        assertEquals(4, CountBinarySubstrings.countBinarySubstrings("10101"));
    }
}