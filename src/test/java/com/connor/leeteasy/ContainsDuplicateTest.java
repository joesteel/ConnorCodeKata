package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    void shouldFindDuplicate() {
        int[] arr = new int[]{1,3,4,1};
        assertTrue(ContainsDuplicate.containsDuplicate(arr));
    }

    @Test
    void shouldNotFindDuplicate() {
        int[] arr = new int[]{1,3,4,10};
        assertFalse(ContainsDuplicate.containsDuplicate(arr));
    }
}