package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void shouldSerializeStringToNodeList() {
        String s = "1 2";
        ListNode root = ListNode.serialiseList(s);
        assertEquals(1,root.val);
        assertEquals(2,root.next.val);
        assertNull(root.next.next);
    }

    @Test
    void shouldSerializeStringToNodeListOneElement() {
        String s = "1";
        ListNode root = ListNode.serialiseList(s);
        assertEquals(1,root.val);
        assertNull(root.next);
    }
}