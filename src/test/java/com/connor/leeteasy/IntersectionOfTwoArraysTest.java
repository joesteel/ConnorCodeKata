package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArraysTest {

    @Test
    void shouldReturnIntersection() {
        int[] nums1 = new int[]{1,2,2,3}, nums2 = new int[]{2,2};
        int[] result = IntersectionOfTwoArrays.intersection(nums1, nums2);
        assertArrayEquals(new int[]{2}, result);
    }

    @Test
    void shouldReturnNoIntersection() {
        int[] nums1 = new int[]{1,2,2,3}, nums2 = new int[]{8};
        int[] result = IntersectionOfTwoArrays.intersection(nums1, nums2);
        assertArrayEquals(new int[]{}, result);
    }
}