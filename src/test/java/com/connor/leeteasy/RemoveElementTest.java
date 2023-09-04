package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @Test
    void shouldBeNoChangeForArrayWithoutElementToChange() {
        int[] nums = new int[]{1,1,1,1};
        int[] expected_result = new int[]{1,1,1,1};
        int val = 0;
        RemoveElement.removeElement(nums, val);
        assertArrayEquals(nums, expected_result);
    }


    @Test
    void shouldRemoveElement() {
        int[] nums = new int[]{1,2};
        int[] expected_result = new int[]{2,2};
        int val = 1;
        assertEquals(1, RemoveElement.removeElement(nums, val));
        assertArrayEquals(nums, expected_result);
    }

    @Test
    void shouldRemoveTwoElementsStochastic() {
        int[] nums = new int[]{1,3,0,1,2};
        int[] expected_result = new int[]{3,0,2,2,2};
        int val = 1;
        int result = RemoveElement.removeElement(nums, val);
        assertEquals(3, result);
    }

    @Test
    void shouldRemoveTwoElementsStochastic_complex() {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int result = RemoveElement.removeElement(nums, val);
        assertEquals(5, result);
    }
}