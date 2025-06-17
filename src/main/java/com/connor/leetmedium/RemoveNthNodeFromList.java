package com.connor.leetmedium;
import com.connor.leeteasy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromList {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd(head, n, true);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n, boolean twoPointer) {
        if(twoPointer) return removeNthFromEndTwoPointer(head, n);
        else return removeNthFromEndIndex(head,n);
    }
    private static ListNode removeNthFromEndIndex(ListNode head, int n) {
        if (head == null) return head;

        ListNode node = head;
        List<ListNode> indexes = new ArrayList<>(5);
        final int partition_size = 5;
        int count = 0;
        while (node != null) {
            count++;
            if (count % partition_size == 1) indexes.add(node);
            node = node.next;
        }

        if (n == count) return head.next;
        if (n > count) return head;

        int position_to_change = count - n;
        ListNode closest_node = indexes.get((position_to_change - 1) / partition_size);
        int distance_from_index = (position_to_change - 1) % partition_size;

        while (distance_from_index-- > 0) closest_node = closest_node.next;
        closest_node.next = closest_node.next.next;

        return head;
    }

    private static ListNode removeNthFromEndTwoPointer(ListNode head, int n) {
        ListNode l = head, r = head;
        while (n > 0) {
            r = r.next;
            n--;
            if (r == null) return head;
            if(r.next == null) return l.next;
        }

        while (l != null) {
            r = r.next;
            if (r == null) { // we're at the end
                l.next = l.next.next;
                break;
            }
            l = l.next;
        }
        return head;
    }

}
