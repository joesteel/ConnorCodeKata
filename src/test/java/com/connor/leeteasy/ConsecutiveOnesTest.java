package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveOnesTest {

    @Test
    void shouldFindNoOnes() {
        int result = ConsecutiveOnes.findMaxConsecutiveOnes(new int[]{0,0,0});
        assertEquals(0, result);
    }

    @Test
    void shouldFindOneOne() {
        int result = ConsecutiveOnes.findMaxConsecutiveOnes(new int[]{0,1,0});
        assertEquals(1, result);
    }

    @Test
    void shouldFindOneOneWithMultipleOnes() {
        int result = ConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,0});
        assertEquals(1, result);
    }

    @Test
    void shouldFindTwoOnesWithMultipleOnes() {
        int result = ConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1});
        assertEquals(2, result);
    }
}