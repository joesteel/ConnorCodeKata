package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTreeDepthTest {

    @Test
    void shouldReturn0ForEmptyTree() {
        TreeNode node = null;
        assertEquals(0, MaxTreeDepth.maxDepth(node));
    }

    @Test
    void shouldReturn0ForBalancedTreeHeight2() {
        TreeNode node = TreeNode.DeserializeTree("1 2 x x 2 x x");
        assertEquals(2, MaxTreeDepth.maxDepth(node));
    }


    @Test
    void shouldReturn0ForUnbalancedTreeHeight3() {
        TreeNode node = TreeNode.DeserializeTree("1 2 3 x x x 2 x x");
        assertEquals(3, MaxTreeDepth.maxDepth(node));
    }
}