package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelativeRanksTest {
    @Test
    void shouldWork() {
        assertArrayEquals(new String[]{"Gold Medal", "Silver Medal"}, RelativeRanks.findRelativeRanks(new int[]{3, 1}));
        assertArrayEquals(new String[]{"Gold Medal","Silver Medal","Bronze Medal"}, RelativeRanks.findRelativeRanks(new int[]{10,5,1}));
        assertArrayEquals(new String[]{"Silver Medal", "Gold Medal", "Bronze Medal"}, RelativeRanks.findRelativeRanks(new int[]{10,11,1}));
        assertArrayEquals(new String[]{"Silver Medal", "Gold Medal", "Bronze Medal", "4"}, RelativeRanks.findRelativeRanks(new int[]{10,11,1, 0}));

    }
}