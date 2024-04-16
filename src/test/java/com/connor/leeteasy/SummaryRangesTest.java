package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SummaryRangesTest {

    @Test
    void shouldSummarizeEmptyArray() {
        int[] nums = new int[]{};
        List<String> result = SummaryRanges.summaryRanges(nums);
        assertTrue(result.size() == 0);
    }

    @Test
    void shouldSummarizeEmptyArraySize1() {
        int[] nums = new int[]{1};
        List<String> result = SummaryRanges.summaryRanges(nums);
        assertTrue(result.equals(Arrays.asList("1")));
    }

    @Test
    void shouldSummarizeBaseCase() {
        int[] nums = new int[]{1,2,3,4};
        List<String> result = SummaryRanges.summaryRanges(nums);
        assertTrue(result.equals(Arrays.asList("1->4")));
    }

    @Test
    void shouldSummarizeBaseCase_1() {
        int[] nums = new int[]{1,2,3,4,8,9,20};
        List<String> result = SummaryRanges.summaryRanges(nums);
        assertTrue(result.equals(Arrays.asList("1->4", "8->9", "20")));
    }
}