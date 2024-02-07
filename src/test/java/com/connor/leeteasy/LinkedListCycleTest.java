package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    @Test
    void shouldDetectCycle() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next =  new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = first.next;

        assertTrue(LinkedListCycle.hasCycle(first));
    }
}