package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeAdditionIITest {
    @Test
    void shouldDoRangeAddition() {
        assertEquals(4, RangeAdditionII.maxCount(3,  3, new int[][]{{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}));
        assertEquals(9, RangeAdditionII.maxCount(3,  3, new int[][]{}));
        assertEquals(4, RangeAdditionII.maxCount(3,  3, new int[][]{ {2,2},{3,3}}));
    }
}