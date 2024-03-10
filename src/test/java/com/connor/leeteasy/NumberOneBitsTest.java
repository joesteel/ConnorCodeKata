package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOneBitsTest {

    @Test
    void shouldCount0() {
        int result = NumberOneBits.hammingWeight(0);
        assertEquals(0,result);
    }

    @Test
    void shouldCount1() {
        int result = NumberOneBits.hammingWeight(1);
        assertEquals(1,result);
    }

    @Test
    void shouldCount4() {
        int result = NumberOneBits.hammingWeight(15);
        assertEquals(4,result);
    }
}