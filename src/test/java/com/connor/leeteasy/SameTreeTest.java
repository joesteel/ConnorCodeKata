package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameTreeTest {

    @Test
    void shouldDetectSameTrees() {
        TreeNode tree1 = TreeNode.DeserializeTree("1 2 x x 3 x x");
        TreeNode tree2 = TreeNode.DeserializeTree("1 2 x x 3 x x");
        assertTrue(SameTree.isSameTree(tree1, tree2));
    }

    @Test
    void shouldDetectSameTrees_RightUnbalanced () {
        TreeNode tree1 = TreeNode.DeserializeTree("1 2 x 4 x x 3 x x");
        TreeNode tree2 = TreeNode.DeserializeTree("1 2 x 4 x x 3 x x");
        assertTrue(SameTree.isSameTree(tree1, tree2));
    }


    @Test
    void shouldDetectDifferentTrees() {
        TreeNode tree1 = TreeNode.DeserializeTree("1 x x");
        TreeNode tree2 = TreeNode.DeserializeTree("1 2 x x 3 x x");
        assertFalse(SameTree.isSameTree(tree1, tree2));
    }
}