package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestHarmoniousSubsequenceTest {

    @Test
    void shouldReturnLHS() {
        assertEquals(2, LongestHarmoniousSubsequence.findLHS(new int[]{1,2,3,4}));
        assertEquals(0, LongestHarmoniousSubsequence.findLHS(new int[]{1,1,1,1}));
        assertEquals(5, LongestHarmoniousSubsequence.findLHS(new int[]{1,3,2,2,5,2,3,7}));

    }
}