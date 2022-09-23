package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LowestCommonAncestorTest {

    @Test
    void shouldThrowAnExceptionIfTreeIsEmpty() {
        TreeNode<Integer> root = null;
        boolean exceptionCaught = false;
        try {
            int result = BinarySearchTree.lcaOnBst(root, 10, 20);
        } catch (Exception e){
            exceptionCaught = true;
            System.out.println(e.getMessage());
        }
        assertTrue(exceptionCaught);
    }

    @Test
    void shouldThrowAnExceptionIfNodesAreNotInTree() {
        TreeNode<Integer> root = new TreeNode<>(5);
        boolean exceptionCaught = false;
        try {
            int result = BinarySearchTree.lcaOnBst(root, 10, 20);
        } catch (Exception e){
            exceptionCaught = true;
            System.out.println(e.getMessage());
        }
        assertTrue(exceptionCaught);
    }


    @Test
    void shouldFindCommonAncestorForTreeOfHeightOne() {
        TreeNode<Integer> root = DFSOnTree.deserialize("10 5 x x 15");
        assertEquals(10, BinarySearchTree.lcaOnBst(root, 15, 5));
    }

    @Test
    void shouldFindCommonAncestorForTreeOfHeightOneButOnlyTwoNodes() {
        TreeNode<Integer> root = DFSOnTree.deserialize("10 5");
        assertEquals(10, BinarySearchTree.lcaOnBst(root, 10, 5));
    }

    @Test
    void shouldFindCommonAncestorForTreeOfHeightTwo() {
        TreeNode<Integer> root = DFSOnTree.deserialize("20 10 5 x x 15 x x 30");
        assertEquals(10, BinarySearchTree.lcaOnBst(root, 5, 15));
    }

    @Test
    void shouldFindCommonAncestorForTreeOfHeightTwoWithAncestorOnTop() {
        TreeNode<Integer> root = DFSOnTree.deserialize("20 10 5 x x 15 x x 30");
        assertEquals(20, BinarySearchTree.lcaOnBst(root, 5, 30));
    }

}

