package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void shouldReturn1WhenGiven0() {
        int[] digits = new int[]{0};
        int[] result = PlusOne.plusOne(digits);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void shouldDealWithOverFlow() {
        int[] digits = new int[]{9};
        int[] result = PlusOne.plusOne(digits);
        assertArrayEquals(new int[]{1, 0}, result);
    }

    @Test
    void shouldDealWithOverFlowInSequence() {
        int[] digits = new int[]{4,5,9};
        int[] result = PlusOne.plusOne(digits);
        assertArrayEquals(new int[]{4, 6, 0}, result);
    }

    @Test
    void shouldDealWithOverFlowOnLargeNumber() {
        int[] digits = new int[]{9,9,9};
        int[] result = PlusOne.plusOne(digits);
        assertArrayEquals(new int[]{1,0,0,0}, result);
    }
}