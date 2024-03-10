package com.connor.leeteasy;

import java.util.List;

public class RemoveLinkedListElement {
    public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;
        if(head == null) return null;

        ListNode p1 = head, p2 = p1.next;
        while(p2 != null){
            if(p2.val == val) {
                p1.next=null;
                p2 = p2.next;
            } else {
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
