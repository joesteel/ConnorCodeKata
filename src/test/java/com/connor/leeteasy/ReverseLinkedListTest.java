package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void shouldReturnNullForEmptyList() {
        ListNode head = null;
        ListNode reversedList = ReverseLinkedList.reverseList(head);
        assertNull(reversedList);
    }
    @Test
    void shouldReturnheadForAListOfSizeOne() {
        ListNode head = new ListNode(1);
        ListNode reversedListHead = ReverseLinkedList.reverseList(head);
        assertEquals(1, reversedListHead.val);
    }

    @Test
    void shouldReverseAListOfSizeTwo() {
        ListNode head = ListNode.serialiseList("1 2");
        ListNode reversedListHead = ReverseLinkedList.reverseList(head);
        assertEquals(2, reversedListHead.val);
        assertEquals(1, reversedListHead.next.val);

    }


}