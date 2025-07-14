package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveNthNodeFromListTest {


    @Test
    void shouldRemoveNth() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 2);
        assertEquals(5, ListNode.getNth(4, result).val);
    }

    @Test
    void shouldRemoveNth_2() {
        ListNode head = ListNode.serialiseList("1 2");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 1);
        assertEquals(null, result.next);
    }

    @Test
    void shouldRemoveFirst() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 5);
        assertEquals(2, result.val);
    }

    @Test
    void shouldDealWithNulls() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 5);
        assertEquals(2, result.val);
    }

    @Test
    void shouldDealWithLastElementBeingSelectedForRemoval() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5 6 7 8");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 1);
        assertEquals(7, ListNode.getNth(7, result).val);
        assertEquals(null, ListNode.getNth(7, result).next);
    }

    @Test
    void shouldRemoveNthLarge() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5 6 7 8 9 10");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 2);
        assertEquals(10, ListNode.getNth(9, result).val);
    }

    @Test
    void shouldRemoveNthLarge_2() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 4);
        assertEquals(15, ListNode.getNth(15, result).val);
        assertEquals(17, ListNode.getNth(16, result).val);
    }
}