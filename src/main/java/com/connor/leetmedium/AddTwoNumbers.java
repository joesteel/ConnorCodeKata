package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode sums = new ListNode(0);
        ListNode sums_head = sums;

        // we can do this all in a single loop.... we just have to set null lists to 0
        // however this will be a bit slower as you'll run through to the full size of both lists


        // keep going until one of the lists is dry
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (carry ? 1:0);
            carry = false;
            sums.next = new ListNode(sum % 10);
            if(sum > 9) carry = true;
            l1 = l1.next;
            l2 = l2.next;
            sums = sums.next;
        }

        // ok one of the lists is dry, so we need to keep going with the other one
        ListNode remaining = l1 != null ? l1 : l2;
        while(carry) {
            int sum = 1 + (remaining != null ? remaining.val : 0);
            carry = false;
            sums.next = new ListNode(sum % 10);
            if(sum > 9) carry = true;
            sums = sums.next;
            if(remaining != null) remaining = remaining.next;
        }

        // if we have run out of carry but still have remaining digits, just append them
        if(remaining != null) sums.next = remaining;

        return sums_head.next;
    }
}
