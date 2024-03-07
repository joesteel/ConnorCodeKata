package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {


    @Test
    void shouldReverseZero() {
        int n = 0x0000;
        int result = ReverseBits.reverseBits(n);
        assertEquals(0, result);
    }

    @Test
    void shouldReverseToOne() {
        int n = 0x80000000;
        int result = ReverseBits.reverseBits(n);
        assertEquals(1, result);
    }

    @Test
    void shouldReverseTo0x8() {
        int n = 0x00000001;
        int result = ReverseBits.reverseBits(n);
        assertEquals(0x80000000, result);
    }

    @Test
    void shouldReverseToEight() {
        int n = 0x10000000;
        int result = ReverseBits.reverseBits(n);
        assertEquals(8, result);
    }

    @Test
    void shouldReverseToNine() {
        int n = 0x90000000;
        int result = ReverseBits.reverseBits(n);
        assertEquals(9, result);
    }

    @Test
    void shouldReverseTo15() {
        int n = 0xF0000000;
        int result = ReverseBits.reverseBits(n);
        assertEquals(15, result);
    }


    @Test
    void shouldReverseAll1s() {
        int n = 0xFFFFFFFF;
        int result = ReverseBits.reverseBits(n);
        assertEquals(0xFFFFFFFF, result);
    }

}