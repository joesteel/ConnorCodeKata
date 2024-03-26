package com.connor.leeteasy;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ptr1 = head, ptr2 = ptr1.next, ptr3;
        while(ptr2 != null){
            ptr3 = ptr2.next;
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
        }
        head.next = null;
        return ptr1;
    }
}
