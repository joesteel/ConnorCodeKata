package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {

    @Test
    void shouldComputeHammingDistance() {
        assertEquals(32, HammingDistance.hammingDistance(0xFFFFFFFF,0));
        assertEquals(31, HammingDistance.hammingDistance(Integer.MAX_VALUE,0));
        assertEquals(2, HammingDistance.hammingDistance(0,3));
        assertEquals(0, HammingDistance.hammingDistance(1,1));
        assertEquals(1, HammingDistance.hammingDistance(1,0));

    }
}