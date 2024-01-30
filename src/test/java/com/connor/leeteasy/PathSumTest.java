package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    @Test
    void shouldReturnTrueFor1NodeTree() {
        boolean result = PathSum.hasPathSum(TreeNode.DeserializeTree("3 x x"), 3);
        assertTrue(result);
    }


    @Test
    void shouldReturnFalseFor1NodeTree() {
        boolean result = PathSum.hasPathSum(TreeNode.DeserializeTree("3 x x"), 4);
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueFor4NodeTreeLeftSubtree() {
        boolean result = PathSum.hasPathSum(TreeNode.DeserializeTree("1 2 x x 4 x x"), 3);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueFor4NodeTreeRightSubtree() {
        boolean result = PathSum.hasPathSum(TreeNode.DeserializeTree("1 2 x x 4 x x"), 5);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseFor4NodeTreeWhereSumExistsButNotOnLeaf() {
        boolean result = PathSum.hasPathSum(TreeNode.DeserializeTree("1 2 x x 4 x x"), 1);
        assertFalse(result);
    }
}