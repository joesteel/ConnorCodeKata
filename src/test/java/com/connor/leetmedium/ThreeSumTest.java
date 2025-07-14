package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void shouldDetect3Sums() {
        assertEquals(1, ThreeSum.threeSum(new int[]{0,0,0,0}).size());
        assertEquals(2, ThreeSum.threeSum(new int[]{-1,0,1,2,-1,-4}).size());
        assertEquals(2, ThreeSum.threeSum(new int[]{-2,0,1,1,2}).size());
        assertEquals(1, ThreeSum.threeSum(new int[]{0,1,2,-3}).size());
        assertEquals(1, ThreeSum.threeSum(new int[]{-1,0,1}).size());
        assertEquals(0, ThreeSum.threeSum(new int[]{0,0,1}).size());

    }
}