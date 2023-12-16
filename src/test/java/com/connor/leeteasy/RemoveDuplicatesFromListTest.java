package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromListTest {

    @Test
    void shouldOneElement() {
        ListNode root = ListNode.serialiseList("1");
        ListNode result_head = RemoveDuplicatesFromList.deleteDuplicates(root);
        assertEquals(1, result_head.val);
        assertNull(result_head.next);
    }

    @Test
    void shouldTwoElements() {
        ListNode root = ListNode.serialiseList("1 2");
        ListNode result_head = RemoveDuplicatesFromList.deleteDuplicates(root);
        assertEquals(1, result_head.val);
        assertEquals(2, result_head.next.val);
        assertNull(result_head.next.next);
    }

    @Test
    void shouldRemoveDupesTwoElements() {
        ListNode root = ListNode.serialiseList("1 1");
        ListNode result_head = RemoveDuplicatesFromList.deleteDuplicates(root);
        assertEquals(1, result_head.val);
        assertNull(result_head.next);
    }

    @Test
    void shouldRemoveDupesFourElements() {
        ListNode root = ListNode.serialiseList("1 1 2 2");
        ListNode result_head = RemoveDuplicatesFromList.deleteDuplicates(root);
        assertEquals(1, result_head.val);
        assertEquals(2, result_head.next.val);
        assertNull(result_head.next.next);
    }

    @Test
    void shouldRemoveDupesEightElements() {
        ListNode root = ListNode.serialiseList("1 1 1 1 2 2 2");
        ListNode result_head = RemoveDuplicatesFromList.deleteDuplicates(root);
        assertEquals(1, result_head.val);
        assertEquals(2, result_head.next.val);
        assertNull(result_head.next.next);
    }
}