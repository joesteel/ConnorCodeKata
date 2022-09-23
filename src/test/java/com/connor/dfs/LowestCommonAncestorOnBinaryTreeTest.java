package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LowestCommonAncestorOnBinaryTreeTest {
    @Test
    void shouldFindPathToNodeAllLeft() {
        ArrayList<TreeNode<Integer>> path = new ArrayList<>();
        TreeNode<Integer> root = DFSOnTree.deserialize("10 3 5 7 9 x x x x x 30");
        DFSOnTree.findPathToNode(root, root.left.left.left, path);
        assertTrue(path.get(0) == root && path.get(1) == root.left && path.get(2) == root.left.left);
        assertTrue(path.size() == 4);
    }


    @Test
    void shouldFindPathToNodeAllRight() {
        ArrayList<TreeNode<Integer>> path = new ArrayList<>();
        TreeNode<Integer> root = DFSOnTree.deserialize("10 x 5 x 9 x 12 x 30 x x");
        DFSOnTree.findPathToNode(root, root.right.right.right.right, path);
        assertTrue(
                path.get(0) == root
                && path.get(1) == root.right
                && path.get(2) == root.right.right
                && path.get(3) == root.right.right.right
        );
        assertTrue(path.size() == 5);
    }

    @Test
    void shouldFindPathToNodeLeftThenRight() {
        ArrayList<TreeNode<Integer>> path = new ArrayList<>();
        TreeNode<Integer> root = DFSOnTree.deserialize("10 4 5 x x 9 x x 12 x x");
        DFSOnTree.findPathToNode(root, root.left.right, path);
        assertTrue(
                path.get(0) == root
                        && path.get(1) == root.left
        );
        assertTrue(path.size() == 3);
    }

    @Test
    void shouldBeEmptyPathForNullTree() {
        ArrayList<TreeNode<Integer>> path = new ArrayList<>();
        TreeNode<Integer> root = DFSOnTree.deserialize("10 4 5 x x 9 x x 12 x x");
        DFSOnTree.findPathToNode(null, root.left.right, path);
        assertTrue(path.size() == 0);
    }

    @Test
    void shouldBeEmptyPathWhereNodeDoesNotExistInTree() {
        ArrayList<TreeNode<Integer>> path = new ArrayList<>();
        TreeNode<Integer> root = DFSOnTree.deserialize("10 4 5 x x 9 x x 12 x x");
        TreeNode<Integer> orphanedNode = new TreeNode<>(100);
        DFSOnTree.findPathToNode(root, orphanedNode, path);
        assertTrue(path.size() == 0);
    }

    @Test
    void shouldFindLCAOnTreeUsingPath() {
        TreeNode<Integer> root = DFSOnTree.deserialize("6 4 3 x x 5 x x 8 x x");
        assertTrue(root.equals(DFSOnTree.lca(root, root, root.right)));
    }

    @Test
    void shouldFindLCAOnTreeUsingChildKnowledge() {
        TreeNode<Integer> root = DFSOnTree.deserialize("6 4 3 x x 5 x x 8 x x");
        assertTrue(root.equals(DFSOnTree.lca(root, root, root.right, 1)));
    }

    @Test
    void shouldReturnRootForSimpleTree() {
        TreeNode<Integer> root = DFSOnTree.deserialize("6 4 x x 5");
        assertTrue(root.equals(DFSOnTree.lca(root, root.left, root.right, 1)));
    }

}
