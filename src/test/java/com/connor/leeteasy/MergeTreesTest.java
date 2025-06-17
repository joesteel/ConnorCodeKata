package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTreesTest {

    @Test
    void shouldMergeTreesOneOverlappingNode() {
        TreeNode result = MergeTrees.mergeTrees(TreeNode.DeserializeTree("1 x x"),TreeNode.DeserializeTree("1 x x"));
        assertEquals(2,result.val);
        assertTrue(result.left == null && result.right == null);
    }

    @Test
    void shouldMergeTreesNonOverlappingNodes() {
        TreeNode result = MergeTrees.mergeTrees(TreeNode.DeserializeTree("1 2 x x x"),TreeNode.DeserializeTree("1 x x"));
        assertEquals(2,result.val);
        assertTrue(result.left.val == 2 && result.right == null);
    }
}