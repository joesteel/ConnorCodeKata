package com.connor.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LargestDivisibleSubsetTest {

    @Test
    void shouldReturnOneForArrayOfSizeOne() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1));
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(1, result);
    }


    @Test
    void shouldReturnOneForArrayOfSizeTwoWithNoDivisors() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,3));
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTwoForArrayOfSizeTwoWithTwoDivisors() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,4));
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTwoForArrayOfSizeThreeWithTwoDivisors() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,4,7));
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTwoForArrayOfSizeFourWithFourDivisors() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(4, result);
    }

    @Test
    void shouldReturnComplexResult() {
        List<Integer> nums = Arrays.stream("125 1 8 3 24 9 18 2 4 25 12 72".split(" "))
                .map(x->Integer.parseInt(x))
                .collect(Collectors.toList());
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(6, result);
    }

    @Test
    void shouldReturnComplexResult_2() {
        List<Integer> nums = Arrays.stream("896000 43200 480 117600000 1960000 17920 403200 35 140000 4200 140 1075200 56000 39200000 7 1120000 35280 84000 1481760 15120 54880 2520000 439040000 282240 240 453600 10080 33600 26880 47040 2520 4480 282240000 21600 174960 360 564480 11340000 7840 10080000 112000 40 7840000 80 11200 89600 4536000 1960 1600 756 2222640 164640 3920 560000 3920000 20 3200 2400 3240 126 2268000 16200 12 10800 19600 12600 252000 160 280000 300 840 302400 4 196000 78400 448000 400 176400 960 120 31360000 5600 7560 9072000 1120 32000 317520 141120 62720 241920 180 32 1 31360 10 274400 3 156800 23520 1411200 168000 17280 11760 5880 28000 44800 134400 179200 17640 107520 35280000 235200000 2160 2240 60 219520000 2721600 215040 35840 15680 3600 1905120 2419200 15 19440 280 45360 5 2800 846720000 50400 30 504000 18 41160 188160 8640".split(" "))
                .map(x->Integer.parseInt(x))
                .collect(Collectors.toList());
        int result = LargestDivisibleSubset.findLargestSubset(nums);
        assertEquals(18, result);
    }
}