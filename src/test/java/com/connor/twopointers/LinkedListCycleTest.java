package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {
    @Test
    void shouldBuildLinkedListFromString() {
        String serializedList = "1 2 3";
        LinkedListCycle.Node<Integer> root = LinkedListCycle.deserializeList(serializedList);
        assertTrue(root.val == 1);
        assertTrue(root.next.val == 2);
        assertTrue(root.next.next.val == 3);
    }

    @Test
    void shouldFindNoCycleInListWithNoCycle() {
        String serializedList = "1 2 3 4 5 6 7 8 9 10";
        LinkedListCycle.Node<Integer> root = LinkedListCycle.deserializeList(serializedList);
        Boolean res = LinkedListCycle.hasCycle(root);
        assertFalse(res);
    }


    @Test
    void shouldFindNoCycleInListWithCycle() {
        String serializedList = "1 2 3";
        LinkedListCycle.Node<Integer> root = LinkedListCycle.deserializeList(serializedList);
        root.next.next.next = root;
        Boolean res = LinkedListCycle.hasCycle(root);
        assertTrue(res);
    }
}