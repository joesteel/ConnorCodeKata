package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateIITest {

    @Test
    void shouldReturnIfDuplicateExistsAtKInterval() {
        int[] nums = new int[]{1,2,3,4,5,1};
        int k = 5;
        assertTrue(ContainsDuplicateII.containsNearbyDuplicate(nums, k));
    }

    @Test
    void shouldReturnIfNoDuplicateExists() {
        int[] nums = new int[]{1,2,3,4,5,6};
        int k = 5;
        assertFalse(ContainsDuplicateII.containsNearbyDuplicate(nums, k));
    }

    @Test
    void shouldReturnDuplicateWhenWeReachEnd() {
        int[] nums = new int[]{1,1};
        int k = 2;
        assertTrue(ContainsDuplicateII.containsNearbyDuplicate(nums, k));
    }
}