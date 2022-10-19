package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {


    @Test
    void shouldReturnCombinationForSimpleSum() {
        int target = 4;
        List<Integer> candidates = Arrays.asList(4);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList(Arrays.asList(4))));
    }

    @Test
    void shouldReturnCombinationForSimpleSum2() {
        int target = 4;
        List<Integer> candidates = Arrays.asList(2,1);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList(Arrays.asList(2,2), Arrays.asList(1,1,2), Arrays.asList(1,1,1,1))));
    }

    @Test
    void shouldReturnCombinationForSimpleSum3() {
        int target = 8;
        List<Integer> candidates = Arrays.asList(2,3,5);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList(Arrays.asList(2,2,2,2), Arrays.asList(2,3,3), Arrays.asList(3,5))));
    }

    @Test
    void shouldReturnEmptyForImpossibleCombo() {
        int target = 8;
        List<Integer> candidates = Arrays.asList(10);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList()));
    }

    @Test
    void shouldReturnCombinationForSimpleSum4() {
        int target = 2;
        List<Integer> candidates = Arrays.asList(1);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList(Arrays.asList(1,1))));
    }

    @Test
    void shouldReturnCombinationForSimpleSumDupes() {
        int target = 4;
        List<Integer> candidates = Arrays.asList(4);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target, "dupes");
        assertTrue(results.equals(Arrays.asList(Arrays.asList(4))));
    }

    @Test
    void shouldReturnCombinationForSimpleSum4Dupes() {
        int target = 2;
        List<Integer> candidates = Arrays.asList(1);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target, "dupes");
        assertTrue(results.equals(Arrays.asList(Arrays.asList(1,1))));
    }

    @Test
    void shouldReturnCombinationForSimpleSum3Dupes() {
        int target = 8;
        List<Integer> candidates = Arrays.asList(2,3,5);
        List<List<Integer>> results = CombinationSum.combinationSum(candidates, target);
        assertTrue(results.equals(Arrays.asList(Arrays.asList(2,2,2,2), Arrays.asList(2,3,3), Arrays.asList(3,5))));
    }

}