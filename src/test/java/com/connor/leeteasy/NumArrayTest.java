package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumArrayTest {

    @Test
    void shouldSumRange() {
        NumArray na = new NumArray(new int[]{1,1,1,1,1});

        assertEquals(1, na.sumRange(0,0));
        assertEquals(2, na.sumRange(0,1));
        assertEquals(3, na.sumRange(0,2));
        assertEquals(4, na.sumRange(0,3));
        assertEquals(5, na.sumRange(0,4));


        assertEquals(1, na.sumRange(1,1));
        assertEquals(2, na.sumRange(1,2));
        assertEquals(3, na.sumRange(1,3));
        assertEquals(4, na.sumRange(1,4));

        assertEquals(1, na.sumRange(2,2));
        assertEquals(2, na.sumRange(2,3));
        assertEquals(3, na.sumRange(2,4));

        assertEquals(1, na.sumRange(3,3));
        assertEquals(2, na.sumRange(3,4));

        assertEquals(1, na.sumRange(4,4));

        assertEquals(1, na.sumRange(0,0));
        assertEquals(1, na.sumRange(1,1));
        assertEquals(1, na.sumRange(2,2));
        assertEquals(1, na.sumRange(3,3));
        assertEquals(1, na.sumRange(4,4));
    }
}