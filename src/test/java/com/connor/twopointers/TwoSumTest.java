package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void shouldReturnSumForSimpleArr() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,3,4,5,6));
        int target = 2;
        List<Integer> result = TwoSum.twoSumSorted(arr, target);
        assertTrue(result.equals(Arrays.asList(0,1)));
    }


    @Test
    void shouldReturnNullForArrWithNoValidAns() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,3,4,5,6));
        int target = 20;
        List<Integer> result = TwoSum.twoSumSorted(arr, target);
        assertTrue(result == null);
    }

}