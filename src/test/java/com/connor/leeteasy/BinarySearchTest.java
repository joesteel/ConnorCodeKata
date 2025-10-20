package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void shouldFindTargetInArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = binarySearch.search(nums, target);
        assertEquals(4, result);
    }

    @Test
    void shouldReturnNotFoundWhenTargetDoesntExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = -5;
        int result = binarySearch.search(nums, target);
        assertEquals(-1, result);
    }

}