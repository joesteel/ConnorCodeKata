package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingBitsTest {


    @Test
    void shouldCountBitsNegative() {
        int[] result = CountingBits.countBits(-34);
        assertEquals(0, result.length);
    }
    @Test
    void shouldCountBits0() {
        int[] result = CountingBits.countBits(0);
        assertEquals(1, result.length);
        assertEquals(0, result[0]);
    }


    @Test
    void shouldCountBits1() {
        int[] result = CountingBits.countBits(1);
        assertEquals(2, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }


    @Test
    void shouldCountBits2() {
        int[] result = CountingBits.countBits(2);
        assertEquals(3, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(1, result[2]);
    }


    @Test
    void shouldCountBits3() {
        int[] result = CountingBits.countBits(3);
        assertEquals(4, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(1, result[2]);
        assertEquals(2, result[3]);
    }


    @Test
    void shouldCountBits15() {
        int[] result = CountingBits.countBits(15);
        assertEquals(16, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);

        assertEquals(1, result[2]);
        assertEquals(2, result[3]);

        assertEquals(1, result[4]);
        assertEquals(2, result[5]);
        assertEquals(2, result[6]);
        assertEquals(3, result[7]);

        assertEquals(1, result[8]);
        assertEquals(2, result[9]);
        assertEquals(2, result[10]);
        assertEquals(3, result[11]);
        assertEquals(2, result[12]);
        assertEquals(3, result[13]);
        assertEquals(3, result[14]);
        assertEquals(4, result[15]);
    }
}