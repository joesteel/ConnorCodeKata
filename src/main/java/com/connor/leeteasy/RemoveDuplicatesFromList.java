package com.connor.leeteasy;

public class RemoveDuplicatesFromList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        head.next = deleteDuplicates(head.next);
        if(head.next != null && head.next.val == head.val) return head.next;
        else return head;
    }

}
