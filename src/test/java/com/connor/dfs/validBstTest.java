package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class validBstTest {

    @Test
    void shouldReturnTrueForEmptyTree() {
        TreeNode<Integer> root = null;
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root));
    }

    @Test
    void shouldReturnTrueForTreeOfOneNode() {
        TreeNode<Integer> root = new TreeNode<>(10);
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root));
    }

    @Test
    void shouldReturnTrueForSmallTreeWhichIsValid() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("5 5 x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root));
    }

    @Test
    void shouldReturnFalseForSmallTreeWhichIsNotValid() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 15 x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse(bst.validBst(root));
    }

    @Test
    void shouldReturnFalseForSmallTreeWhereAllNodesAreEven() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 10 x x 10");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root));
    }


    @Test
    void shouldReturnFalseForComplexValidTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 9 8 x 9 x x x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root));
    }

    @Test
    void shouldReturnFalseForMoreComplexValidTree() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("6 4 3 x x 8 x x 8 x x");
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse(bst.validBst(root));
    }



    @Test
    void shouldReturnTrueForEmptyTreeUsingRange() {
        TreeNode<Integer> root = null;
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

    @Test
    void shouldReturnTrueForTreeOfOneNodeUsingRange() {
        TreeNode<Integer> root = new TreeNode<>(10);
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

    @Test
    void shouldReturnTrueForSmallTreeWhichIsValidUsingRange() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("5 5 x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

    @Test
    void shouldReturnFalseForSmallTreeWhichIsNotValidUsingRange() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 15 x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

    @Test
    void shouldReturnFalseForSmallTreeWhereAllNodesAreEvenUsingRange() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 10 x x 10");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }


    @Test
    void shouldReturnFalseForComplexValidTreeUsingRange() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("10 9 8 x 9 x x x x 12");
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

    @Test
    void shouldReturnFalseForMoreComplexValidTreeUsingRange() {
        DFSOnTree dfs = new DFSOnTree();
        TreeNode<Integer> root = dfs.deserialize("6 4 3 x x 8 x x 8 x x");
        BinarySearchTree bst = new BinarySearchTree();
        assertFalse(bst.validBst(root, BinarySearchTree.RANGE_CHECK));
    }

}
