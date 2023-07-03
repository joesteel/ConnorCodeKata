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
        ListNode result = new ListNode();
        ListNode resPtr = result;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                resPtr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                resPtr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            resPtr = resPtr.next;
        }
        while(list1 != null) {
            resPtr.next = new ListNode(list1.val);
            list1 = list1.next;
            resPtr = resPtr.next;
        }
        while(list2 != null) {
            resPtr.next = new ListNode(list2.val);
            list2 = list2.next;
            resPtr = resPtr.next;
        }
        return result.next;
    }
}
