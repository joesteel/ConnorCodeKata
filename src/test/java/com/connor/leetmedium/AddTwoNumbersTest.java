package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    @Test
    void shouldAddTwoNumbersEqualListSize() {
        ListNode result = AddTwoNumbers.addTwoNumbers(
                ListNode.serialiseList("1 2 3"),
                ListNode.serialiseList("1 2 3")
        );
        assertEquals(2, result.val);
        assertEquals(4, result.next.val);
        assertEquals(6, result.next.next.val);
    }

    @Test
    void shouldAddTwoNumbersUnEqualListSize() {
        ListNode result = AddTwoNumbers.addTwoNumbers(
                ListNode.serialiseList("1 2 3"),
                ListNode.serialiseList("1 2")
        );
        assertEquals(2, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
    }

    @Test
    void shouldAddTwoNumbersCarryOnLast() {
        ListNode result = AddTwoNumbers.addTwoNumbers(
                ListNode.serialiseList("1 2 9 9"),
                ListNode.serialiseList("1 2 1")
        );
        assertEquals(2, result.val);
        assertEquals(4, result.next.val);
        assertEquals(0, result.next.next.val);
        assertEquals(0, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }

    @Test
    void shouldDealWithEmptyList() {
        ListNode result = AddTwoNumbers.addTwoNumbers(
                null,
                null
        );
        assertNull(result);
    }
}