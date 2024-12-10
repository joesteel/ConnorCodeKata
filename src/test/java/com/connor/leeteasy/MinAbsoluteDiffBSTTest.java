package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAbsoluteDiffBSTTest {
    @Test
    void shouldFindMinPositiveDiff_RightSubTree() {
        TreeNode root = TreeNode.DeserializeTree("5 4 x x 7 x x");
        assertEquals(1, MinAbsoluteDiffBST.getMinimumDifference(root));
    }

    @Test
    void shouldFindMinPositiveDiff_LeftSubTree() {
        TreeNode root = TreeNode.DeserializeTree("9 2 1 x x x 10 x x");
        assertEquals(1, MinAbsoluteDiffBST.getMinimumDifference(root));
    }

    @Test
    void shouldFindMinPositiveDiff_RightUnbalancedSubTree() {
        TreeNode root = TreeNode.DeserializeTree("1 x 5 3 x x x ");
        assertEquals(2, MinAbsoluteDiffBST.getMinimumDifference(root));
    }
}