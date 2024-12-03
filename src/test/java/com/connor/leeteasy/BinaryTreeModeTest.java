package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeModeTest {

    @Test
    void shouldReturnOneforTreeSizedOne() {
        TreeNode root = new TreeNode(1);
        int[] result = BinaryTreeMode.findMode(root);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void shouldReturnEmptyForNullTree() {
        int[] result = BinaryTreeMode.findMode(null);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void shouldReturnOneforComplexBST() {
        TreeNode root = TreeNode.DeserializeTree("1 1 x x x");
        int[] result = BinaryTreeMode.findMode(root);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void shouldReturnOneforComplexBST_2() {
        TreeNode root = TreeNode.DeserializeTree("3 1 x x x");
        int[] result = BinaryTreeMode.findMode(root);
        assertArrayEquals(new int[]{3, 1}, result);
    }

    @Test
    void shouldReturnOneforComplexBST_3() {
        TreeNode root = TreeNode.DeserializeTree("3 1 1 x x x x");
        int[] result = BinaryTreeMode.findMode(root);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void shouldReturnOneforComplexBST_4() {
        TreeNode root = TreeNode.DeserializeTree("3 1 x x 6 x x");
        int[] result = BinaryTreeMode.findMode(root);
        assertArrayEquals(new int[]{1, 2, 6}, result);
    }

}