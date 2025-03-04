package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTiltTest {

    @Test
    void shouldComputeTilt() {
        assertEquals(61, BinaryTreeTilt.findTilt(TreeNode.DeserializeTree("1 20 30 x x 31 x x 21 x x")));
        assertEquals(0, BinaryTreeTilt.findTilt(TreeNode.DeserializeTree("1 1 x x 1 x x")));
        assertEquals(5, BinaryTreeTilt.findTilt(TreeNode.DeserializeTree("1 5 x x x")));
        assertEquals(4, BinaryTreeTilt.findTilt(TreeNode.DeserializeTree("1 -1 x x 3 x x")));
        assertEquals(3, BinaryTreeTilt.findTilt(TreeNode.DeserializeTree("1 0 x x 3 x x")));
    }
}