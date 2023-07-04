package com.connor.leeteasy;

import java.util.List;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode resPtr = head;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                resPtr.next = list1;
                list1 = list1.next;
            } else {
                resPtr.next = list2;
                list2 = list2.next;
            }
            resPtr = resPtr.next;
        }
        if (list1 != null) resPtr.next = list1;
        else resPtr.next = list2;

        return head.next;
    }

    public static ListNode mergeTwoListsCopiedFromL33tSubmission(ListNode list1, ListNode list2) {
        if(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                list1.next = mergeTwoListsCopiedFromL33tSubmission(list1.next, list2);
                return list1;

            } else {
                list2.next = mergeTwoListsCopiedFromL33tSubmission(list1, list2.next);
                return list2;
            }
        }
        if(list1 == null)
            return list2;
        return list1;

    }
}
