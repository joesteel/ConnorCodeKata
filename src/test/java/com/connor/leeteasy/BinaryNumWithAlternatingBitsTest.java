package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNumWithAlternatingBitsTest {

    @Test
    void shouldDetectBinaryNumWithAlternateBits() {
        assertTrue(BinaryNumWithAlternatingBits.hasAlternatingBits(5)); // 101
        assertTrue(BinaryNumWithAlternatingBits.hasAlternatingBits(10)); // 1010
    }

    @Test
    void shouldDetectBinaryNumWithoutAlternateBits() {
        assertFalse(BinaryNumWithAlternatingBits.hasAlternatingBits(7)); // 111
        assertFalse(BinaryNumWithAlternatingBits.hasAlternatingBits(11)); // 1011
    }
}