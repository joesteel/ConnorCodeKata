package com.connor.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeSerializerTest {

    @Test
    void shouldSerializeEmptyTree() {
        TreeNode<Integer> root = null;
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        assertTrue(serializedTree.equals("x"));
    }

    @Test
    void shouldDeSerializeEmptyTree() {
        TreeNode<Integer> root = null;
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        assertTrue(dfs.deserialize(serializedTree) == null);
    }

    @Test
    void shouldSerializeTreeWithOneNode() {
        TreeNode<Integer> root = new TreeNode<>(10);
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        assertTrue(serializedTree.equals("10 x x"));
    }


    @Test
    void shouldDeSerializeOneNodeTree() {
        TreeNode<Integer> root = new TreeNode<>(10);
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        assertTrue(dfs.deserialize(serializedTree).val == 10);
        assertTrue(dfs.deserialize(serializedTree).left == null);
        assertTrue(dfs.deserialize(serializedTree).right == null);
    }



    @Test
    void shouldSerializeLeftSidedTree() {
        TreeBuilder<Integer> tb = new TreeBuilder<>();
        TreeNode<Integer> root = tb.buildTreeFromString("12345", Character::getNumericValue);
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        assertTrue(serializedTree.equals("1 2 3 4 5 x x x x x x"));
    }

    @Test
    void shouldDeSerializeLeftSidedTree() {
        TreeBuilder<Integer> tb = new TreeBuilder<>();
        TreeNode<Integer> root = tb.buildTreeFromString("12345", Character::getNumericValue);
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        TreeNode<Integer> reconstitutedTreeRoot = dfs.deserialize(serializedTree);
        assertTrue(dfs.serialize(reconstitutedTreeRoot).equals("1 2 3 4 5 x x x x x x"));
    }

    @Test
    void shouldDeSerializeRightSidedTree() {
        TreeBuilder<Integer> tb = new TreeBuilder<>();
        TreeNode<Integer> root = tb.buildTreeFromString("1x2x3x4x5", Character::getNumericValue);
        DFSOnTree dfs = new DFSOnTree();
        String serializedTree = dfs.serialize(root);
        TreeNode<Integer> reconstitutedTreeRoot = dfs.deserialize(serializedTree);
        assertTrue(dfs.serialize(reconstitutedTreeRoot).equals("1 x 2 x 3 x 4 x 5 x x"));
    }

}
