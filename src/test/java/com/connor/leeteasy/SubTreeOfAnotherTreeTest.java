package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubTreeOfAnotherTreeTest {

    @Test
    void shouldDetectSimpleTreeMatchFailure() {
        TreeNode root = TreeNode.DeserializeTree("1 x x");
        TreeNode subTree =  TreeNode.DeserializeTree("2 x x");
        assertFalse(SubTreeOfAnotherTree.isSubtree(root, subTree));
    }

    @Test
    void shouldDetectSimpleTreeMatchFailure_nulls() {
        TreeNode root = TreeNode.DeserializeTree("1 x x");
        assertTrue(SubTreeOfAnotherTree.isSubtree(root, null));
    }

    @Test
    void shouldDetectSimpleTreeMatchSuccess() {
        TreeNode root = TreeNode.DeserializeTree("1 x x");
        TreeNode subTree =  TreeNode.DeserializeTree("1 x x");
        assertTrue(SubTreeOfAnotherTree.isSubtree(root, subTree));
    }

    @Test
    void shouldDetectComplexTreeMatchSuccess() {
        TreeNode root = TreeNode.DeserializeTree("3 4 1 x x 2 x x 5 x 0 x x");
        TreeNode subTree =  TreeNode.DeserializeTree("4 1 x x 2 x x");
        assertTrue(SubTreeOfAnotherTree.isSubtree(root, subTree));
    }

    @Test
    void shouldDetectComplexTreeMatchFailure_2() {
        TreeNode root = TreeNode.DeserializeTree("3 4 1 0 x x x 2 x x 5 x 0 x x");
        TreeNode subTree =  TreeNode.DeserializeTree("4 1 x x 2 x x");
        assertFalse(SubTreeOfAnotherTree.isSubtree(root, subTree));
    }

    @Test
    void shouldDetectComplexTreeMatchSuccess_2() {
        TreeNode root = TreeNode.DeserializeTree("1 x 1 x x");
        TreeNode subTree =  TreeNode.DeserializeTree("1 x 1 x x");
        assertTrue(SubTreeOfAnotherTree.isSubtree(root, subTree));
    }

}