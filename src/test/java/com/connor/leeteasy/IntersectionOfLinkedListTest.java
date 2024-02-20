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


}