package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListsTest {

    @Test
    void shouldMergeSimpleListsMaxNumsInListTwo() {
        int[] one = new int[]{1,0};
        int[] two = new int[]{3};
        MergeSortedLists.merge(one, 1, two, 1);
        assertArrayEquals(new int[]{1,3}, one);
    }

    @Test
    void shouldMergeSimpleListsMaxNumsInListOne() {
        int[] one = new int[]{3,0};
        int[] two = new int[]{1};
        MergeSortedLists.merge(one, 1, two, 1);
        assertArrayEquals(new int[]{1,3}, one);
    }

    @Test
    void shouldMergeListsWithInterleavedMaximums() {
        int[] one = new int[]{1,2,0,0};
        int[] two = new int[]{1,3};
        MergeSortedLists.merge(one, 2, two, 2);
        assertArrayEquals(new int[]{1,1,2,3}, one);
    }

    @Test
    void shouldMergeListsWhenOneFinishesFirst() {
        int[] one = new int[]{3,4,0,0};
        int[] two = new int[]{1,2};
        MergeSortedLists.merge(one, 2, two, 2);
        assertArrayEquals(new int[]{1,2,3,4}, one);
    }
    @Test
    void shouldMergeListsWhenTwoFinishesFirst() {
        int[] one = new int[]{1,2,0,0};
        int[] two = new int[]{3,4};
        MergeSortedLists.merge(one, 2, two, 2);
        assertArrayEquals(new int[]{1,2,3,4}, one);
    }
}