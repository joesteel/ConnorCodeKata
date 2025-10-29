package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {

    @Test
    void shouldFindPivotIndex() {
        assertEquals(5, FindPivotIndex.pivotIndex(new int[] {-1,-1,0,1,1,0})); 
        assertEquals(-1, FindPivotIndex.pivotIndex(new int[] {-1,-1,-1,-1,-1,-1})); // sum = -6, -6/2 = -3 - (- 1) = -2
        assertEquals(0, FindPivotIndex.pivotIndex(new int[] {2,1,-1}));
        assertEquals(-1, FindPivotIndex.pivotIndex(new int[] {1,2,3}));
        assertEquals(3, FindPivotIndex.pivotIndex(new int[] {1,7,3,6,5,6}));
    }
}