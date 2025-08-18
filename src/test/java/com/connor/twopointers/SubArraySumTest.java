package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SubArraySumTest {

    @Test
    void shouldCalcSimpleSum() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,-6));
        int target = -3;
        List<Integer> result = SubArraySum.subarraySum(arr, target);
        assertTrue(result.equals(Arrays.asList(2,3)));
    }


    @Test
    void shouldCalcSimpleSum_2() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, -20, -3, 30, 5, 4));
        int target = 7;
        List<Integer> result = SubArraySum.subarraySum(arr, target);
        assertTrue(result.equals(Arrays.asList(1,3)));
    }


    @Test
    void shouldReturnRunningTotalOfSubArraySums(){
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 6, -6));
        int target = 6;
        int result = SubArraySum.subarraySumTotal(arr, target);
        assertEquals(3, result);
    }


    @Test
    void shouldReturnRunningTotalOfSubArraySums_2(){
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 5, -5, -20, 10));
        int target = -10;
        int result = SubArraySum.subarraySumTotal(arr, target);
        assertEquals(3, result);
    }
}