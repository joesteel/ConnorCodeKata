package com.connor.dfs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertBstTest {

    @Test
    void shouldInsertIntoEmptyTree() {
        TreeNode root = BinarySearchTree.insertBst(null, 10);
        assertEquals(10, root.val);
    }


    @Test
    void shouldNotInsertTreeWithExistingNode() {
        TreeNode root = new TreeNode<>(10);
        root = BinarySearchTree.insertBst(root, 10);
        String serialisedTree = DFSOnTree.serialize(root);
        assertTrue(serialisedTree.equals("10 x x"));
    }

    @Test
    void shouldInsertTreeOfHeightTwo() {
        String tree = "10 5 x x 12";
        String expected = "10 5 x x 12 11 x x x";
        TreeNode root = DFSOnTree.deserialize(tree);
        root = BinarySearchTree.insertBst(root, 11);
        String serialisedTree = DFSOnTree.serialize(root);
        assertTrue(serialisedTree.equals(expected));
    }
}
