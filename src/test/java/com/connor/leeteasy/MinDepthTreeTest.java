package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinDepthTreeTest {

    @Test
    void shouldReturn0ForEmptyTree() {
        int result = MinDepthTree.minDepth(null);
        assertEquals(0, result);
    }

    @Test
    void shouldReturn1ForTreeSize1() {
        int result = MinDepthTree.minDepth(TreeNode.DeserializeTree("1 x x"));
        assertEquals(1, result);
    }

    @Test
    void shouldReturn1ForUnbalancedTreeSize3() {
        int result = MinDepthTree.minDepth(TreeNode.DeserializeTree("1 2 3 x x x x"));
        assertEquals(3, result);
    }


}