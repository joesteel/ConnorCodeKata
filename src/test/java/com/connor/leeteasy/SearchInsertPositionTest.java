package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SearchInsertPositionTest {
    @Test
    void shouldFindTargetInArrayOfSizeOne() {
        int nums[] = new int[]{1};
        int target = 1;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(result, 0);
    }


    @Test
    void shouldFindTargetInBoundaryCondition() {
        int nums[] = new int[]{0,1,2,3,4};
        int target = 4;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(4, result);
    }

    @Test
    void shouldFindTargetAfterTwoPartitions() {
        int nums[] = new int[]{0,1,2,3,4,
                5,6,7,
                8,9,10};
        int target = 9;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(result, 9);
    }


    @Test
    void shouldReturnInsertPositionWhenNotFound() {
        int nums[] = new int[]{0,1,2,3,4,6,7,8};
        int target = 5;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(5, result);
    }


    @Test
    void shouldReturnInsertPositionWhenNotFound_simple() {
        int nums[] = new int[]{1,3};
        int target = 0;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(0, result);
    }

    @Test
    void shouldReturnInsertPositionWhenNotFound_simple2() {
        int nums[] = new int[]{1,3,5,6};
        int target = 7;
        int result = SearchInsertPosition.searchInsert(nums, target);
        assertEquals(4, result);
    }
}