package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    void shouldReturnFalseForNonPalindrome() {
        ListNode list = ListNode.serialiseList("1 1 2 1");
        boolean result = PalindromeLinkedList.isPalindrome(list);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueForEvenPalindrome() {
        ListNode list = ListNode.serialiseList("1 2 2 1");
        boolean result = PalindromeLinkedList.isPalindrome(list);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForOddPalindrome() {
        ListNode list = ListNode.serialiseList("1 2 3 2 1");
        boolean result = PalindromeLinkedList.isPalindrome(list);
        assertTrue(result);
    }
}