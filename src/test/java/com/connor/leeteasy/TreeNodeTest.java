package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void shouldDeserializeSimpleTree() {
        TreeNode root = TreeNode.DeserializeTree("1 x x");
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void shouldDeserialize2TierTree() {
        TreeNode root = TreeNode.DeserializeTree("1 2 x x 3 x x");
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void shouldDeserialize3TierTree_LeftUnbalanced() {
        TreeNode root = TreeNode.DeserializeTree("1 2 x 4 x x 3 x x");
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.right.val);
        assertNull(root.left.left);
        assertEquals(4, root.left.right.val);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void shouldDeserialize3TierTree() {
        TreeNode root = TreeNode.DeserializeTree("1 2 4 x x 5 x x 3 x x");
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertNull(root.left.right.left);
        assertNull(root.left.right.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

}