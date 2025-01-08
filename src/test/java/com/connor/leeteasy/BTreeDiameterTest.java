package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeDiameterTest {

    @Test
    void shouldFindMaxDiameter_1() {
        int result = BTreeDiameter.diameterOfBinaryTree(TreeNode.DeserializeTree("1 x x"));
        assertEquals(0, result);
    }

    @Test
    void shouldFindMaxDiameter_2() {
        assertEquals(3, BTreeDiameter.diameterOfBinaryTree(TreeNode.DeserializeTree("1 2 3 x x 4 x 5 x x x")));
        assertEquals(3, BTreeDiameter.diameterOfBinaryTree(TreeNode.DeserializeTree("1 2 x 4 x x 3 x x")));
        assertEquals(2, BTreeDiameter.diameterOfBinaryTree(TreeNode.DeserializeTree("1 2 x x 3 x x")));
        assertEquals(1, BTreeDiameter.diameterOfBinaryTree(TreeNode.DeserializeTree("1 2 x x x")));
    }
}