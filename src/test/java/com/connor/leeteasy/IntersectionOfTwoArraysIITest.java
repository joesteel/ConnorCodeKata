package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArraysIITest {

    @Test
    void shouldFindIntersection_WithNoDupes() {
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{1,2,6};

        int[] result = IntersectionOfTwoArraysII.intersect(nums1, nums2);
        assertArrayEquals(new int[]{1,2}, result);
    }

    @Test
    void shouldFindIntersection_WithDupes() {
        int[] nums1 = new int[]{1,2, 2, 3,4,5};
        int[] nums2 = new int[]{1,2,6,2};

        int[] result = IntersectionOfTwoArraysII.intersect(nums1, nums2);
        assertArrayEquals(new int[]{1,2,2}, result);
    }

    @Test
    void shouldFindIntersection_WithDupes2() {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        int[] result = IntersectionOfTwoArraysII.intersect(nums1, nums2);
        assertArrayEquals(new int[]{9,4}, result);
    }

    @Test
    void shouldFindIntersection_WhereIntersectionIsEmpty() {
        int[] nums1 = new int[]{1,2, 2, 3,4,5};
        int[] nums2 = new int[]{6,7,8};

        int[] result = IntersectionOfTwoArraysII.intersect(nums1, nums2);
        assertArrayEquals(new int[]{}, result);
    }
}