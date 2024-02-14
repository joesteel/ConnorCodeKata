package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTreePostOrderTest {

    @Test
    void shouldReturnPostOrderTravPath() {
        List<Integer> result = BTreePostOrder.postorderTraversal(TreeNode.DeserializeTree("1 2 x x 3 x x"));
        List<Integer> expectedResult = Arrays.asList(2, 3, 1);
        assertEquals(expectedResult, result);
    }
}