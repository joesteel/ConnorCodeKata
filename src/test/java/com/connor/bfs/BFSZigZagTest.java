package com.connor.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSZigZagTest {

    @Test
    void shouldReturnOneListForTreeWithTwoLevels() {
        String serializedTree = "10 1 x x 2 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<List<Integer>> result = BFSZigZag.zigZagTraversal(root);
        assertTrue(result.equals(Arrays.asList(Arrays.asList(10), Arrays.asList(2, 1))));
    }

    @Test
    void shouldReturnOneListForTreeWithThreeLevels() {
        String serializedTree = "10 21 31 x x 32 x x 22 33 x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<List<Integer>> result = BFSZigZag.zigZagTraversal(root);
        assertTrue(result.equals(Arrays.asList(Arrays.asList(10), Arrays.asList(22, 21), Arrays.asList(31, 32, 33))));
    }

}