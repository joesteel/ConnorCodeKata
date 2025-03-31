package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void shouldComputeCWMWFromArraySize2() {
        assertEquals(0, ContainerWithMostWater.maxArea(new int[]{0,2}));
        assertEquals(2, ContainerWithMostWater.maxArea(new int[]{2,2}));
    }

    @Test
    void shouldComputeCWMWFromLargerArray_evenSizes() {
        assertEquals(4, ContainerWithMostWater.maxArea(new int[]{2,2,2}));
        assertEquals(0, ContainerWithMostWater.maxArea(new int[]{0,2,0}));
    }

    @Test
    void shouldComputeCWMWFromLargerArray_growingInSize() {
        assertEquals(49, ContainerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(17, ContainerWithMostWater.maxArea(new int[]{ 2,3,4,5,18,17,6}));
        assertEquals(12, ContainerWithMostWater.maxArea(new int[]{2,6,2,6,1}));
        assertEquals(6, ContainerWithMostWater.maxArea(new int[]{2,6,6}));
    }
}