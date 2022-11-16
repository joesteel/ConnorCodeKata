package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    @Test
    void shouldMerge1EmptyList() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList());
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertEquals(0, res.size());
    }

    @Test
    void shouldMerge2EmptyLists() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList());
        sortedLists.add(Arrays.asList());
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertEquals(0, res.size());
    }

    @Test
    void shouldMerge1List() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,2,3));
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertTrue(res.equals(Arrays.asList(1,2,3)));
    }


    @Test
    void shouldMerge2ListsOfSize1() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1));
        sortedLists.add(Arrays.asList(0));
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1)));
    }

    @Test
    void shouldMerge2ListsOfSize3() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0,2,4));
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5)));
    }

    @Test
    void shouldMerge3ListsOfSize3() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0,2,4));
        sortedLists.add(Arrays.asList(6,7,8));
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5,6,7,8)));
    }

    @Test
    void shouldMerge4ListsOfVaryingSizes() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0));
        sortedLists.add(Arrays.asList(2,4,6,7,8));
        List<Integer> res = MergeKSortedLists.mergeKSortedLists(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5,6,7,8)));
    }


    @Test
    void shouldMerge1EmptyList_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList());
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertEquals(0, res.size());
    }

    @Test
    void shouldMerge2EmptyLists_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList());
        sortedLists.add(Arrays.asList());
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertEquals(0, res.size());
    }

    @Test
    void shouldMerge1List_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,2,3));
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertTrue(res.equals(Arrays.asList(1,2,3)));
    }


    @Test
    void shouldMerge2ListsOfSize1_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1));
        sortedLists.add(Arrays.asList(0));
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1)));
    }

    @Test
    void shouldMerge2ListsOfSize3_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0,2,4));
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5)));
    }

    @Test
    void shouldMerge3ListsOfSize3_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0,2,4));
        sortedLists.add(Arrays.asList(6,7,8));
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5,6,7,8)));
    }

    @Test
    void shouldMerge4ListsOfVaryingSizes_WithElement() {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1,3,5));
        sortedLists.add(Arrays.asList(0));
        sortedLists.add(Arrays.asList(2,4,6,7,8));
        List<Integer> res = MergeKSortedLists.mergeSortedListsUsingElement(sortedLists);
        assertTrue(res.equals(Arrays.asList(0,1,2,3,4,5,6,7,8)));
    }
}