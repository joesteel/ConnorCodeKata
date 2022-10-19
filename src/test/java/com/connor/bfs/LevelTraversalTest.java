package com.connor.bfs;

import com.connor.backtracking.TreeHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelTraversalTest {


    @Test
    void shouldReturnOneListForTreeWithOnlyRoot() {
        String serializedTree = "10 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<List<Integer>> result = LevelTraversal.levelOrderTraversal(root);
        assertTrue(result.equals(Arrays.asList(Arrays.asList(10))));
    }

    @Test
    void shouldReturnOneListForTreeWithTwoLevels() {
        String serializedTree = "10 1 x x 2 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<List<Integer>> result = LevelTraversal.levelOrderTraversal(root);
        assertTrue(result.equals(Arrays.asList(Arrays.asList(10), Arrays.asList(1,2))));
    }




}