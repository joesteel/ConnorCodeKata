package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    @Test
    void shouldReturnSubsetsForListOfOne() {
        List<Integer> nums = Arrays.asList(1);
        List<List<Integer>> result = Subsets.subsets(nums);
        assertTrue(result.equals(Arrays.asList(Arrays.asList(1))));
    }

    @Test
    void shouldReturnSubsetsForListOfTwo() {
        List<Integer> nums = Arrays.asList(1,2);
        List<List<Integer>> result = Subsets.subsets(nums);
        assertTrue(result.containsAll(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(1,2))));
    }

    @Test
    void shouldReturnSubsetsForListOfThree() {
        List<Integer> nums = Arrays.asList(1,2,3);
        List<List<Integer>> result = Subsets.subsets(nums);
        assertTrue(result.containsAll(Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(2),
                Arrays.asList(3)
        )));
    }

}