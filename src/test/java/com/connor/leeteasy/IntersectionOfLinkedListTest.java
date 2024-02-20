package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfLinkedListTest {


    @Test
    void shouldFindIntersection() {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        B.next = A;
        ListNode C = new ListNode(3);
        C.next = A;

        ListNode headC = C;
        ListNode headB = B;

        ListNode result = IntersectionOfLinkedList.getIntersectionNode(headB, headC);
        assertEquals(A, result);
    }

    @Test
    void shouldReverseLinkedListSize0() {
        ListNode head = null;
        ListNode reversedHead = IntersectionOfLinkedList.reverseList(head);
        assertNull(reversedHead);
    }

    @Test
    void shouldReverseLinkedListSize1() {
        ListNode head = new ListNode(1);
        ListNode reversedHead = IntersectionOfLinkedList.reverseList(head);
        assertEquals(1, reversedHead.val);
        assertNull(reversedHead.next);
    }

    @Test
    void shouldReverseLinkedListSize2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode reversedHead = IntersectionOfLinkedList.reverseList(head);
        assertEquals(2, reversedHead.val);
        assertEquals(1, reversedHead.next.val);
        assertNull(reversedHead.next.next);
    }

    @Test
    void shouldReverseLinkedListSize3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode reversedHead = IntersectionOfLinkedList.reverseList(head);
        assertEquals(3, reversedHead.val);
        assertEquals(2, reversedHead.next.val);
        assertEquals(1, reversedHead.next.next.val);
        assertNull(reversedHead.next.next.next);
    }

}