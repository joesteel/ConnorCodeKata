package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTreePreOrderTest {

    @Test
    void shouldReturnPreOrderTraversalList() {
        List<Integer> result = BTreePreOrder.preorderTraversal(TreeNode.DeserializeTree("1 2 x x 3 x x"));
        List<Integer> expectedResult = Arrays.asList(1, 2, 3);
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnPreOrderTraversalListWithNulls() {
        List<Integer> result = BTreePreOrder.preorderTraversal(TreeNode.DeserializeTree("1 x 3 4 x x x"));
        List<Integer> expectedResult = Arrays.asList(1, 3, 4);
        assertEquals(expectedResult, result);
    }
}