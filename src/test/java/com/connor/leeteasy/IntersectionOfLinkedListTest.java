package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfLinkedListTest {


    @Test
    void shouldFindIntersection_1() {
        ListNode A = new ListNode(1);

        ListNode headC = A;
        ListNode headB = A;

        ListNode result = IntersectionOfLinkedList.getIntersectionNode(headB, headC);
        assertEquals(A, result);
    }
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


}