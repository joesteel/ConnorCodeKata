package com.connor.leeteasy;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AverageOfLevelsTest {

    @Test
    void shouldAvgAllTheValuesUsingDFS() {
        assertEquals(2, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 2 x x 3 x x")).size());
        assertEquals(4, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 2 4 x x x 3 x 4 x x")).get(2));
        assertEquals(1, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 x x")).size());
    }

    @Test
    void shouldAvgAllTheValuesUsingBFS() {
        assertEquals(4, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 2 4 x x x 3 x 4 x x"), false).get(2));
        assertEquals(2, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 2 x x 3 x x"), false).size());
        assertEquals(1, AverageOfLevels.averageOfLevels(TreeNode.DeserializeTree("1 x x"), false
        ).size());
    }
}