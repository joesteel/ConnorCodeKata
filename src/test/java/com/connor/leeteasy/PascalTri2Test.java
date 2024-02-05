package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalTri2Test {

    @Test
    void shouldReturnNullFor0SizeTri() {
        List<Integer> result = PascalTri2.getRow(0);
        assertNull(result);
    }

    @Test
    void shouldReturn1ForSizeTri1() {
        List<Integer> result = PascalTri2.getRow(1);
        assertEquals(Arrays.asList(1), result);
    }


    @Test
    void shouldReturn1ForSizeTri2() {
        List<Integer> result = PascalTri2.getRow(2);
        assertEquals(Arrays.asList(1, 1), result);
    }

    @Test
    void shouldReturn1ForSizeTri4() {
        List<Integer> result = PascalTri2.getRow(4);
        assertEquals(Arrays.asList(1, 3, 3, 1), result);
    }
}