package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SymmetricTreeTest {
    @Test
    void shouldDetectSymmetricTreeOfDepth1() {
        assertTrue(SymmetricTree.isSymmetric(TreeNode.DeserializeTree("1 x x")));
    }

    @Test
    void shouldDetectSymmetricTreeOfDepth2() {
        assertTrue(SymmetricTree.isSymmetric(TreeNode.DeserializeTree("1 2 x x 2 x x")));
    }

    @Test
    void shouldDetectNonSymmetricTreeOfDepth2() {
        assertFalse(SymmetricTree.isSymmetric(TreeNode.DeserializeTree("1 2 x x 3 x x")));
    }

    @Test
    void shouldDetectSymmetricTreeOfDepth4() {
        assertTrue(SymmetricTree.isSymmetric(TreeNode.DeserializeTree("1 2 4 x x 3 x x 2 3 x x 4 x x")));
    }

    @Test
    void shouldDetectNonSymmetricTreeOfDepth4() {
        assertFalse(SymmetricTree.isSymmetric(TreeNode.DeserializeTree("1 2 4 x x 3 x x 2 4 x x 3 x x")));
    }
}