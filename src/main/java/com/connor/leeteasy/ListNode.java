package com.connor.leeteasy;

import java.util.Arrays;
import java.util.Iterator;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode serialiseList(String s) {
         Iterator<String> itr = Arrays.stream(s.split(" ")).iterator();
         return createNode(itr);
    }

    private static ListNode createNode(Iterator<String> itr){
        ListNode node = null;
         if (itr.hasNext()) {
             node = new ListNode(Integer.parseInt(itr.next()));
             node.next = createNode(itr);
         }
         return node;
    }
}