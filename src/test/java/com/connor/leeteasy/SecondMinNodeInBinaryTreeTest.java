package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondMinNodeInBinaryTreeTest {

    @Test
    void shouldFindSecondMin() {
        assertEquals(2, SecondMinNodeInBinaryTree.findSecondMinimumValue(TreeNode.DeserializeTree("1 1 2 x x x 3 4 x x 5 x x")));
        assertEquals(2, SecondMinNodeInBinaryTree.findSecondMinimumValue(TreeNode.DeserializeTree("1 2 x x 3 x x")));
    }

    @Test
    void shouldReturnNotFoundIfNoSecondMin() {
        assertEquals(-1, SecondMinNodeInBinaryTree.findSecondMinimumValue(TreeNode.DeserializeTree("1 x x")));
    }
}