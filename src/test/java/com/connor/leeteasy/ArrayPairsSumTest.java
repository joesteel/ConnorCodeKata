package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayPairsSumTest {

    @Test
    void shouldWork() {
        assertEquals(4, ArrayPairsSum.arrayPairSum(new int[]{1,4,3,2}));
        assertEquals(9, ArrayPairsSum.arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
}