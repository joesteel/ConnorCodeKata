package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumIITest {

    @Test
    public void shouldFindCombinationSum() {
        int target = 4;
        List<List<Integer>> results = CombinationSumII.combinationSum2(new int[]{4}, target);
        assertEquals(results, List.of(List.of(4)));
    }

    @Test
    public void shouldFindCombinationSum2() {
        int target = 5;
        List<List<Integer>> results = CombinationSumII.combinationSum2(new int[] {2,5,2,1,2}, target);
        assertEquals(List.of(List.of(1,2,2), List.of(5)), results);
    }

    @Test
    public void shouldFindCombinationSum3() {
        int target = 8;
        List<List<Integer>> results = CombinationSumII.combinationSum2(new int[]{2,3,5}, target);
        assertEquals(results, List.of(List.of(3,5)));
    }

    @Test
    public void shouldFindCombinationSum4() {
        int target = 8;
        List<List<Integer>> results = CombinationSumII.combinationSum2(new int[]{10,1,2,7,6,1,5}, target);
        assertEquals(List.of(List.of(1,1,6), List.of(1,2,5), List.of(1,7), List.of(2,6)), results);
    }
}