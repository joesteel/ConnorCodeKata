package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdMaxTest {

    @Test
    void shouldReturnThirdMax_Array_Size1() {
        assertEquals(1, ThirdMax.thirdMax(new int[] {1}));
    }

    @Test
    void shouldReturnThirdMax_Array_Size2() {
        assertEquals(2, ThirdMax.thirdMax(new int[] {2,1}));
    }

    @Test
    void shouldReturnThirdMax_Array_Size3() {
        assertEquals(1, ThirdMax.thirdMax(new int[] {2,2,3,1}));
    }

    @Test
    void shouldReturnThirdMax_Array_Size2_MinVal_Present() {
        assertEquals(Integer.MIN_VALUE, ThirdMax.thirdMax(new int[] {2,1, Integer.MIN_VALUE}));
    }
}