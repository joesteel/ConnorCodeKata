package com.connor.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeBuilderTest {

    @Test
    void shouldCreateEmptyTreeFromEmptyInput() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertTrue(root == null);
    }

    @Test
    void shouldCreateEmptyTreeFromNullInput() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "xxx";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertTrue(root == null);
    }

    @Test
    void shouldCreateOneNodeWithCorrectValue() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "1";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertEquals(1, root.val);
    }

    @Test
    void shouldCreateMultipleLeftSideNodesWithCorrectValue() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "123";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.left.left.val);
    }

    @Test
    void shouldCreateBalancedTreeFromBalancedInput() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "12xx3";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
    }

    @Test
    void shouldCreateRightHeavyTreeFromInput() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "1x2x3x4";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);
    }

    @Test
    void shouldCreateComplexTreeFromInput() {
        TreeBuilder<Integer> tb = new TreeBuilder();
        String serialisedTree = "543xx8xx6xx";
        TreeNode root = tb.buildTreeFromString(serialisedTree, 0, Character::getNumericValue);
        assertEquals(5, root.val);
        assertEquals(4, root.left.val);
        assertEquals(3, root.left.left.val);
        assertEquals(8, root.left.right.val);
        assertEquals(6, root.right.val);
    }


}