package com.connor.leeteasy;

public class IntersectionOfLinkedList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode reverseHeadA = reverseList(headA);
        ListNode reverseHeadB = reverseList(headB);
        ListNode result = null;
        while(reverseHeadA != null && reverseHeadB != null){
            if(reverseHeadA.val == reverseHeadB.val) {
                result = reverseHeadA;
                reverseHeadA = reverseHeadA.next;
                reverseHeadB = reverseHeadB.next;
            } else return result;
        }
        return result;
    }
    
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode left = null;
        ListNode middle = head;
        ListNode right = middle;
        while(middle != null) {
            right = right.next;
            middle.next = left;
            left = middle;
            middle = right;
        }

        return left;
    }
}
