package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTreePathsTest {

    @Test
    void shouldReturnPathsWithEmptyTree() {
        List<String> paths = BTreePaths.binaryTreePaths(null);
        assertEquals(0, paths.size());
    }

    @Test
    void shouldReturnPathsWithTreeSize1() {
        List<String> paths = BTreePaths.binaryTreePaths(TreeNode.DeserializeTree("1"));
        assertEquals(1, paths.size());
        assertEquals("1", paths.get(0));
    }



    @Test
    void shouldReturnPathsWithTreeSize2() {
        List<String> paths = BTreePaths.binaryTreePaths(TreeNode.DeserializeTree("1 2 x x x"));
        assertEquals(1, paths.size());
        assertEquals("1->2", paths.get(0));
    }

    @Test
    void shouldReturnPathsWithTreeSize3() {
        List<String> paths = BTreePaths.binaryTreePaths(TreeNode.DeserializeTree("1 2 x x 3 x x"));
        assertEquals(2, paths.size());
        assertEquals("1->2", paths.get(0));
        assertEquals("1->3", paths.get(1));
    }
}