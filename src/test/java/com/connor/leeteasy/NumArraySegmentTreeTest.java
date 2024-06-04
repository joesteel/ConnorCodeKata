package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumArraySegmentTreeTest {

    @Test
    void shouldBuildSegmentTree() {
        NumArraySegmentTree NASTy = new NumArraySegmentTree(new int[]{1,1,1,1,1});
        assertEquals(NASTy.root.rangeSum, 5);
        assertEquals(NASTy.root.left.rangeSum, 3);
        assertEquals(NASTy.root.right.rangeSum, 2);
        assertEquals(NASTy.root.right.left.rangeSum, 1);
        assertEquals(NASTy.root.right.right.rangeSum, 1);
    }

    @Test
    void shouldComputeRangeSumFullRange() {
        NumArraySegmentTree NASTy = new NumArraySegmentTree(new int[]{1,1,1,1,1});
        assertEquals(5, NASTy.sumRange(0, 4));
    }

    @Test
    void shouldComputeRangeLeftSubTreeRange() {
        NumArraySegmentTree NASTy = new NumArraySegmentTree(new int[]{1,1,1,1,1});
        assertEquals(3, NASTy.sumRange(0, 2));
    }

    @Test
    void shouldComputeRangeRightSubTreeRange() {
        NumArraySegmentTree NASTy = new NumArraySegmentTree(new int[]{1,1,1,1,1});
        assertEquals(2, NASTy.sumRange(3, 4));
    }

    @Test
    void shouldComputeRangeLeftRightPartial() {
        NumArraySegmentTree NASTy = new NumArraySegmentTree(new int[]{1,1,1,1,1});
        assertEquals(3, NASTy.sumRange(2, 4));
    }
}