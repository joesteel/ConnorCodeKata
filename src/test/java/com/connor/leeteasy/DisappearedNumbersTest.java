package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisappearedNumbersTest {

    @Test
    void shouldSolveArraySize2() {
        List<Integer> result = DisappearedNumbers.disappearedNumbers(new int[]{1,1});
        assertEquals(result, Arrays.asList(2));
    }

    @Test
    void shouldSolveArraySize3_OneMissing() {
        List<Integer> result = DisappearedNumbers.disappearedNumbers(new int[]{1,2,2});
        assertEquals(result, Arrays.asList(3));
    }

    @Test
    void shouldSolveArraySize4_2Missing() {
        List<Integer> result = DisappearedNumbers.disappearedNumbers(new int[]{1,2,2,1});
        assertEquals(Arrays.asList(3,4), result);
    }

    @Test
    void shouldSolveArraySize6_5Missing() {
        List<Integer> result = DisappearedNumbers.disappearedNumbers(new int[]{1,1,1,1,1,1});
        assertEquals(Arrays.asList(2,3,4,5,6), result);
    }

    @Test
    void shouldSolveArraySize8_2Missing() {
        List<Integer> result = DisappearedNumbers.disappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        assertEquals(Arrays.asList(5,6), result);
    }
}