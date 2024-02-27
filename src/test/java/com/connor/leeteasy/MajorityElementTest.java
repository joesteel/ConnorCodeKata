package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void shouldFindMajorityElement() {
        int[] nums = new int[] {1,2,2};
        int result = MajorityElement.majorityElement(nums);
        assertEquals(2, result);
    }
}