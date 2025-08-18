package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstAndLastElementSortedArrayTest {

    @Test
    void shouldDetectFirstAndLastWhenOnlyOne() {
        assertArrayEquals(new int[] {3,3}, FirstAndLastElementSortedArray.searchRange(new int[] {1,2,3,4,5,6,7}, 4));
    }


    @Test
    void shouldDetectFirstAndLastWhenMultiple() {
        assertArrayEquals(new int[] {3,4}, FirstAndLastElementSortedArray.searchRange(new int[] {5,7,7,8,8,10}, 8));
        assertArrayEquals(new int[] {2,4}, FirstAndLastElementSortedArray.searchRange(new int[] {1,2,4,4,4,6,7}, 4));
    }


    @Test
    void shouldDetectFirstAndLastWhenNone() {
        assertArrayEquals(new int[] {-1,-1}, FirstAndLastElementSortedArray.searchRange(new int[] {1,2,4,4,4,6,7}, 14));
    }

    @Test
    void shouldDetectFirstAndLastWhenBoundary() {
        assertArrayEquals(new int[] {0,3}, FirstAndLastElementSortedArray.searchRange(new int[] {4,4,4,4}, 4));
    }
}