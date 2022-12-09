package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void shouldReturn0ForEmptyArray() {
        List<Integer> arr = new ArrayList<>(Arrays.asList());
        int result = RemoveDuplicates.removeDuplicates(arr);
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1ForArrayOfSize1() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1));
        int result = RemoveDuplicates.removeDuplicates(arr);
        assertEquals(1, result);
    }

    @Test
    void shouldReturnCorrectResultsForLargeArrayWithAllDupes() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,3,3,4,4));
        int result = RemoveDuplicates.removeDuplicates(arr);
        assertEquals(4, result);
    }
}