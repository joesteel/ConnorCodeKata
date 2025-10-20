package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DegreeOfAnArrayTest {

    @Test
    void shouldDetectDegreeOfAnArray() {
        assertEquals(2, DegreeOfAnArray.findShortestSubArray(new int[]{1,2,2,3,1}));
        assertEquals(6, DegreeOfAnArray.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        assertEquals(1, DegreeOfAnArray.findShortestSubArray(new int[]{1}));
    }
}