package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsBalancedTreeTest {

    @Test
    void shouldReturnTrueForEmptyTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = null;
        assertEquals(true, dfs.isBalanced(root));
    }

    @Test
    void shouldReturnTrueForTreeWithOneNode() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = new TreeNode<>(10);
        assertTrue(dfs.isBalanced(root));
    }

    @Test
    void shouldReturnTrueForBalancedTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("12xx3", Character::getNumericValue);
        assertTrue(dfs.isBalanced(root));
    }

    @Test
    void shouldReturnFalseForLeftSideUnbalancedTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("123456", Character::getNumericValue);
        assertFalse(dfs.isBalanced(root));
    }

    @Test
    void shouldReturnFalseForRightSideUnbalancedTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("1x3x4x5x6x7", Character::getNumericValue);
        assertFalse(dfs.isBalanced(root));
    }

}
