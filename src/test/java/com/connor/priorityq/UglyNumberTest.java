package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UglyNumberTest {

    @Test
    void shouldGetUglyNumber1to6() {
        for(int i = 1; i < 7; i++){
            int result = UglyNumber.nthUglyNumber(i);
            assertEquals(i, result);
        }
    }

    @Test
    void shouldGetUglyNumber7() {
        int result = UglyNumber.nthUglyNumber(7);
        assertEquals(8, result);
    }

    @Test
    void shouldGetUglyNumber10() {
        int result = UglyNumber.nthUglyNumber(10);
        assertEquals(12, result);
    }

    @Test
    void shouldGetUglyNumber25() {
        int result = UglyNumber.nthUglyNumber(25);
        assertEquals(54, result);
    }

}