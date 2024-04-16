package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    @Test
    void shouldInvertBinaryTree() {
        TreeNode tree = TreeNode.DeserializeTree("1 2 x x 3 x x");
        TreeNode result = InvertBinaryTree.invertTree(tree);
        assertEquals(1, result.val);
        assertEquals(3, result.left.val);
        assertEquals(2, result.right.val);
    }
}