package com.connor.leeteasy;

import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightPtr = reverse(slow);
        ListNode leftPtr = head;
        while(rightPtr != null && leftPtr != null){
            if(rightPtr.val != leftPtr.val) return false;
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode next = current;
        ListNode prev = null;
        while(current != null){
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
