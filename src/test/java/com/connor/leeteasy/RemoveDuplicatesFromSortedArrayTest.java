package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {
    @Test
    void shouldWorkForBasicCase() {
        int[] nums = new int[]{1,1};
        int result = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(1, result);
    }

    @Test
    void shouldWorkForLessBasicCase() {
        int[] nums = new int[]{1,1,2};
        int result = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(2, result);
    }

    @Test
    void shouldWorkForMediumComplexityCase() {
        int[] nums = new int[]{1,1,2,2,2,2,3,3,4,4};
        int result = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(4, result);
    }

}