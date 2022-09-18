package com.connor.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class VisibleNodeTest {
    @Test
    void shouldReturnZeroForNullTree() {
        TreeNode<Integer> root = null;
        DFSOnTree dfs = new DFSOnTree();
        assertEquals(0, dfs.visibleTreeNode(root));
    }

    @Test
    void shouldReturnOneForTreeWithNoChildren() {
        TreeNode<Integer> root = new TreeNode<>(100);
        DFSOnTree dfs = new DFSOnTree();
        assertEquals(1, dfs.visibleTreeNode(root));
    }

    @Test
    void shouldReturnThreeForRootWithDominantChildren() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("12xx3", Character::getNumericValue);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(3, mtd.visibleTreeNode(root));
    }

    @Test
    void shouldReturnOneForRootWithSubordinateChildren() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("52xx3", Character::getNumericValue);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(1, mtd.visibleTreeNode(root));
    }

    @Test
    void shouldReturnOneForRootWithComplexTreeStructure() {
        TreeBuilder<Integer> treeBuilder = new TreeBuilder<>();
        TreeNode<Integer> root = treeBuilder.buildTreeFromString("526xxx3x9", Character::getNumericValue);
        DFSOnTree mtd = new DFSOnTree();
        assertEquals(3, mtd.visibleTreeNode(root));
    }

}
