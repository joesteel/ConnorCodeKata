package com.connor.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTreeDepthTest {

    @Test
    void shouldReturnZeroForNullTree() {
        TreeNode<Integer> root = null;
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(0, mtd.treeMaxDepth(root));
    }

    @Test
    void shouldReturnOneForRootWithNoChildren() {
        TreeNode<Integer> root = new TreeNode<Integer>(50);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(1, mtd.treeMaxDepth(root));
    }

    @Test
    void shouldReturnThreeForRootWithThreeLevels() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("123xx4xx5", Character::getNumericValue);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(3, mtd.treeMaxDepth(root));
    }

    @Test
    void shouldReturnCorrectResultForUnbalancedTree() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("1x2x3x4x5x6", Character::getNumericValue);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(6, mtd.treeMaxDepth(root));
    }

}