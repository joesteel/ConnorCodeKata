package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    void shouldReturnMissingNumber() {
        int[] nums = new int[]{0,1,3};
        int result = MissingNumber.missingNumber(nums);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnMissingNumber1_2() {
        int[] nums = new int[]{0,1,3};
        int result = MissingNumber.missingNumber2(nums);
        assertEquals(2, result);
    }



    @Test
    void shouldReturnMissingNumber_2() {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        int result = MissingNumber.missingNumber(nums);
        assertEquals(8, result);
    }



    @Test
    void shouldReturnMissingNumber_2_1() {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        int result = MissingNumber.missingNumber2(nums);
        assertEquals(8, result);
    }

}