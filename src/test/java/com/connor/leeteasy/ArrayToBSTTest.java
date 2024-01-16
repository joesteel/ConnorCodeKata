package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToBSTTest {

    @Test
    void shouldCreateEmptyTreeFromEmptyArray() {
        TreeNode root = ArrayToBST.sortedArrayToBST(new int[]{});
        assertNull(root);
    }

    @Test
    void shouldCreateTreeHeight1FromArrayOf1() {
        TreeNode root = ArrayToBST.sortedArrayToBST(new int[]{1});
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void shouldCreateTreeHeight2FromArrayOf2() {
        TreeNode root = ArrayToBST.sortedArrayToBST(new int[]{1,2});
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }


    @Test
    void shouldCreateTreeHeight2FromArrayOf3() {
        TreeNode root = ArrayToBST.sortedArrayToBST(new int[]{1,2,3});
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

}