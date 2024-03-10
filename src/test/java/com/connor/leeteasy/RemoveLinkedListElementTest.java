package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveLinkedListElementTest {

    @Test
    void shouldNotRemoveNonExistentElement() {
        ListNode head = ListNode.serialiseList("1 2 3");
        ListNode result = RemoveLinkedListElement.removeElements(head, 9);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
    }

    @Test
    void shouldRemoveFirstElement() {
        ListNode head = ListNode.serialiseList("1 2 3");
        ListNode result = RemoveLinkedListElement.removeElements(head, 1);
        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldLastElement() {
        ListNode head = ListNode.serialiseList("1 2 3");
        ListNode result = RemoveLinkedListElement.removeElements(head, 3);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void shouldMultipleElements() {
        ListNode head = ListNode.serialiseList("1 2 2");
        ListNode result = RemoveLinkedListElement.removeElements(head, 2);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    void shouldAllElements() {
        ListNode head = ListNode.serialiseList("2 2 2");
        ListNode result = RemoveLinkedListElement.removeElements(head, 2);
        assertNull(result);
    }

}