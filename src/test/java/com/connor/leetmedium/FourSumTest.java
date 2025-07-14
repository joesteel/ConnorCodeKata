package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

    @Test
    void shouldDoBasic4Sum() {
        List<List<Integer>> result = FourSum.fourSum(new int[]{0,2,2,2,2,2},8);
        assertEquals(1,result.size());
        assertEquals(Arrays.asList(2,2,2,2), result.get(0));
    }

    @Test
    void shouldDoComplex4Sum() {
        long start = System.nanoTime();
        List<List<Integer>> result = FourSum.fourSum(new int[]{1,0,-1,0,-2,2},0);
        long end = System.nanoTime() - start;
        System.out.println("time taken in ms is : " + end);
        assertEquals(3,result.size());
        // assertEquals(Arrays.asList(2,2,2,2), result.get(0));
    }

    @Test
    void shouldDoOverflow4Sum() {
        List<List<Integer>> result = FourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
        assertEquals(0,result.size());
    }
}