package com.connor.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMinDepthTest {

    @Test
    void shouldReturnShallowedLeafForTreeWith1Level() {
        String serializedTree = "10 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        int result = BinaryTreeMinDepth.binaryTreeMinDepth(root);
        assertEquals(0, result);
}

    @Test
    void shouldReturnShallowedLeafForTreeWith3Level() {
        String serializedTree = "10 21 31 x x 32 x x 22 33 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        int result = BinaryTreeMinDepth.binaryTreeMinDepth(root);
        assertEquals(2, result);
    }

    @Test
    void shouldReturnShallowedLeafForTreeWith4Level() {
        String serializedTree = "10 21 31 41 x x x 32 x x 22 x x";
        Node<Integer> root = BinaryTreeHelper.deSerializeTree(Arrays.asList(serializedTree.split(" ")).iterator(), Integer::parseInt);
        int result = BinaryTreeMinDepth.binaryTreeMinDepth(root);
        assertEquals(1, result);
    }
}