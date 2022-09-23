package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void shouldCreateANodeWithCorrectValue() {
        TreeNode node = new TreeNode(10);
        assertEquals(10, node.val);
    }
}