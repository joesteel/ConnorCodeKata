package com.connor.leetmedium;

import com.connor.leeteasy.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode a = head, b = head.next, c = b, r = b;
        while(b != null){
            c = c.next;
            b.next = a;
            a.next = c;

            if(c == null || c.next == null) break; // we have another pair !
            a.next = c.next;
            a = c;
            b = c.next;
            c = c.next;
        }
        return r;
    }
}
