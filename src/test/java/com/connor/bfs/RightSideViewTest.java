package com.connor.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightSideViewTest {

    @Test
    void shouldReturnRightSideViewForTreeWith2Levels() {
        String serializedTree = "10 1 x x 2 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<Integer> result = RightSideView.binaryTreeRightSideView(root);
        assertTrue(result.equals(Arrays.asList(10, 2)));
}

    @Test
    void shouldReturnRightSideViewForTreeWith3Levels() {
        String serializedTree = "10 21 31 x x 32 x x 22 33 x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<Integer> result = RightSideView.binaryTreeRightSideView(root);
        assertTrue(result.equals(Arrays.asList(10, 22, 33)));
    }

    @Test
    void shouldReturnRightSideViewForTreeWith4Levels() {
        String serializedTree = "10 21 31 41 x x x 32 x x 22 33 x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        List<Integer> result = RightSideView.binaryTreeRightSideView(root);
        assertTrue(result.equals(Arrays.asList(10, 22, 33, 41)));
    }

}