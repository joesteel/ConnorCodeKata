package com.connor.leetmedium;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    public void shouldFindCombinationSum() {
        int target = 4;
        List<List<Integer>> results = CombinationSum.combinationSum(new int[]{4}, target);
        assertEquals(results, List.of(List.of(4)));
    }

    @Test
    public void shouldFindCombinationSum2() {
        int target = 7;
        List<List<Integer>> results = CombinationSum.combinationSum(new int[] {2,3,7,8}, target);
        assertEquals(List.of(List.of(2,2,3), List.of(7)), results);
    }

    @Test
    public void shouldFindCombinationSum3() {
        int target = 8;
        List<List<Integer>> results = CombinationSum.combinationSum(new int[]{2,3,5}, target);
        assertEquals(results, List.of(List.of(2,2,2,2), List.of(2,3,3), List.of(3,5)));
    }
}