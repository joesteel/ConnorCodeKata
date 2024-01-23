package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeTest {


    @Test
    void shoudDetectBalancedTreeEvenDepth1() {
        TreeNode node = TreeNode.DeserializeTree("1");
        assertTrue(BalancedBinaryTree.isBalanced(node));
    }

    @Test
    void shoudDetectBalancedTreeUnEvenDepth3() {
        TreeNode node = TreeNode.DeserializeTree("1 2 3 x x x 2 x x");
        assertTrue(BalancedBinaryTree.isBalanced(node));
    }


    @Test
    void shoudDetectUnBalancedTree() {
        TreeNode node = TreeNode.DeserializeTree("1 2 3 4 x x x x 2 x x");
        assertFalse(BalancedBinaryTree.isBalanced(node));
    }

    @Test
    void shoudDetectUnBalancedTreeDepth5() {
        TreeNode node = TreeNode.DeserializeTree("1 2 3 4 5 x x x x x x");
        assertFalse(BalancedBinaryTree.isBalanced(node));
    }
}