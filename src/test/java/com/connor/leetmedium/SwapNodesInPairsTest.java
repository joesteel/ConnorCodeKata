package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {



    @Test
    void shouldSwapOneFive() {
        ListNode result = SwapNodesInPairs.swapPairs(ListNode.serialiseList("1 2 3 4 5"));
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, ListNode.getNth(3, result).val);
        assertEquals(3, ListNode.getNth(4, result).val);
        assertEquals(5, ListNode.getNth(5, result).val);
    }

        @Test
    void shouldSwapOneFour() {
        ListNode result = SwapNodesInPairs.swapPairs(ListNode.serialiseList("1 2 3 4"));
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, ListNode.getNth(3, result).val);
        assertEquals(3, ListNode.getNth(4, result).val);
    }
    @Test
    void shouldSwapOneThree() {
        ListNode result = SwapNodesInPairs.swapPairs(ListNode.serialiseList("1 2 3"));
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, ListNode.getNth(3, result).val);
    }

    @Test
    void shouldSwapOnePair() {
        ListNode result = SwapNodesInPairs.swapPairs(ListNode.serialiseList("1 2"));
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
    }
}