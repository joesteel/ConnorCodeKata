package com.connor.leetmedium;
import com.connor.leeteasy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode node = head;
        List<ListNode> index = new ArrayList<>(5);
        final int index_distance = 5;
        int count = 0;
        index.add(node);
        while(node != null){
            count++;
            if(count % index_distance == 0) index.add(node);
            node = node.next;
        }


        if(n == count) return head.next;

        int position_to_change = count - n;
        ListNode closest_node = index.get(position_to_change/index_distance);
        int distance_from_index = position_to_change%index_distance;

        while(distance_from_index-- > 1 && closest_node!=null){
            closest_node = closest_node.next;
        }

        if(closest_node.next.next != null) closest_node.next = closest_node.next.next;

        return head;
    }
}
