package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {
    @Test
    void shouldFindTarget_WhenRightSubTree_BorderCase() {
        assertEquals(2, SearchInRotatedSortedArray.search(new int[]{4,5,1,2,3}, 1));
    }
    @Test
    void shouldFindTarget_WhenLeftSubTree() {
        assertEquals(4, SearchInRotatedSortedArray.search(new int[]{4,5,6,1,2,3}, 2));
    }
    @Test
    void shouldFindTarget_WhenRightSubTree() {
        assertEquals(1, SearchInRotatedSortedArray.search(new int[]{3,4,5,1,2}, 4));
    }

    @Test
    void shouldFindTarget_WhenInMiddle() {
        assertEquals(0, SearchInRotatedSortedArray.search(new int[]{3,4,5,1,2}, 3));
    }
    @Test
    void shouldFindTarget_BorderCase_Left() {
        assertEquals(0, SearchInRotatedSortedArray.search(new int[]{2,0}, 2));
    }

    @Test
    void shouldNotFindTarget_BorderCase_Left() {
        assertEquals(-1, SearchInRotatedSortedArray.search(new int[]{2,0}, -2));
    }

    @Test
    void shouldFindTarget_BorderCase_Right() {
        assertEquals(1, SearchInRotatedSortedArray.search(new int[]{2,0}, 0));
    }

    @Test
    void shouldNotFindTarget_BorderCase_Right() {
        assertEquals(-1, SearchInRotatedSortedArray.search(new int[]{2,0}, 5));
    }
}