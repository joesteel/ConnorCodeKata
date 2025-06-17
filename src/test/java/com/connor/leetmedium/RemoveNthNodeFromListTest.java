package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveNthNodeFromListTest {


    @Test
    void shouldRemoveNth() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 2);
        assertEquals(5, ListNode.getNth(4, result).val);
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
    void shouldRemoveNthLarge() {
        ListNode head = ListNode.serialiseList("1 2 3 4 5 6 7 8 9 10");
        ListNode result = RemoveNthNodeFromList.removeNthFromEnd(head, 5);
        assertEquals(7, ListNode.getNth(6, result).val);
        assertEquals(10, ListNode.getNth(9, result).val);
    }

}