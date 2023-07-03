package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void shouldMergeAListWithAnEmpty() {
        MergeTwoSortedLists.ListNode list2 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode result = MergeTwoSortedLists.mergeTwoLists(null, list2);
        assertEquals(1, result.val);
    }

    @Test
    void shouldMergeAListWithSimpleList() {
        MergeTwoSortedLists.ListNode list1 = new MergeTwoSortedLists.ListNode(0);
        MergeTwoSortedLists.ListNode list2 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode result = MergeTwoSortedLists.mergeTwoLists(list1, list2);
        assertEquals(0, result.val);
        assertEquals(1, result.next.val);
    }

}