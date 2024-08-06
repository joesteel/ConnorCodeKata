package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfLeftLeavesTest {

    @Test
    void shouldCountLeftLeavesForEmptyTree() {
        assertEquals(0, SumOfLeftLeaves.sumOfLeftLeaves(null));
    }

    @Test
    void shouldCountLeftLeavesForTreeSize1() {
        assertEquals(0, SumOfLeftLeaves.sumOfLeftLeaves(new TreeNode(1)));
    }

    @Test
    void shouldCountLeftLeavesForTree_With_3_Nodes_2_levels() {
        TreeNode root = TreeNode.DeserializeTree("1 2 x x 3 x x");
        assertEquals(2, SumOfLeftLeaves.sumOfLeftLeaves(root));
    }

    @Test
    void shouldCountLeftLeavesForTree_With_4_Nodes_3_levels_Unbalanced_Right() {
        TreeNode root = TreeNode.DeserializeTree("1 2 x x 3 4 x x x");
        assertEquals(6, SumOfLeftLeaves.sumOfLeftLeaves(root));
    }

    @Test
    void shouldCountLeftLeavesForTree_With_4_Nodes_3_levels_Unbalanced_Left() {
        TreeNode root = TreeNode.DeserializeTree("1 2 4 x x x 3 x x");
        assertEquals(4, SumOfLeftLeaves.sumOfLeftLeaves(root));
    }
}