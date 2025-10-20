package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestContinuousIncreasingSubsequenceTest {

    @Test
    void shouldFindLCIS() {
        assertEquals(1, LongestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{1,1,1,0,-5}));
        assertEquals(3, LongestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{6,2,3,4,-1}));
        assertEquals(3, LongestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{10,1,3,5,4,7}));
        assertEquals(5, LongestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{1,2,3,4,5}));
    }
}