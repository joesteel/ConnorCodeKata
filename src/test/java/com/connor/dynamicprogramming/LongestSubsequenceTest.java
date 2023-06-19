package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubsequenceTest {

    @Test
    void shouldReturnOneForListOfSizeOne() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(1));
        assertEquals(1,result);
    }

    @Test
    void shouldReturnTwoForListOfSizeTwoIncreasing() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(1,3));
        assertEquals(2,result);
    }

    @Test
    void shouldReturnOneForListOfSizeTwoDecreasing() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(3, 0));
        assertEquals(1,result);
    }

    @Test
    void shouldReturnOneForLargeListAllDecreasing() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(10,9,8,7,6,5,4,3,2,1,0));
        assertEquals(1,result);
    }

    @Test
    void shouldReturnThreeForListOfSizeFourWithThreeIncreasing() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(1,3,2,4));
        assertEquals(3, result);
    }

    @Test
    void shouldReturnFourForListWithVariance() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(5, 46, 85, 26, 1, 122));
        assertEquals(4, result);
    }

    @Test
    void shouldReturnFourForListWithVariance2() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(50, 3, 10, 80));
        assertEquals(3, result);
    }

    @Test
    void shouldReturnFourForListWithDuplicates() {
        int result = LongestSubsequence.longestSubLenTD(Arrays.asList(0, 0, 1, 6, 0, 0, 0));
        assertEquals(3, result);
    }


}


