package com.connor.leeteasy;

import java.util.List;
import java.util.Stack;

public class IntersectionOfLinkedList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null;

        Stack<ListNode> stackA = new Stack<>();
        ListNode APtr = headA;

        while(APtr != null){
            stackA.push(APtr);
            APtr = APtr.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        ListNode BPtr = headB;

        while(BPtr != null){
            stackB.push(BPtr);
            BPtr = BPtr.next;
        }

        while(APtr == BPtr){
            result = APtr;
            APtr = stackA.pop();
            BPtr = stackB.pop();
        }
        return result;
    }

}
