package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    @Test
    void shouldFindTheSingleNumber() {
        int[] nums = new int[]{2, 2, 1, 3, 4, 4, 3};
        int result = SingleNumber.singleNumber(nums);
        assertEquals(1, result);
    }
}