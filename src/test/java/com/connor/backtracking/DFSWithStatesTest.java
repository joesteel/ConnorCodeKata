package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DFSWithStatesTest {

    @Test
    void shouldReturnEmptyPathForNullTree() {
        Node<Integer> root = null;
        List<String> result = DFSWithStates.ternaryTreePaths(root);
        assertTrue(result.size()==0);
    }

    @Test
    void shouldReturnPathForOneNodeTree() {
        Node<Integer> root = new Node<>(10);
        List<String> result = DFSWithStates.ternaryTreePaths(root);
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).equals("10"));
    }

    @Test
    void shouldReturnPathForTwoNodeTree() {
        String serialisedTree = "10 1 5 0";
        List<String> listOfNodes = new ArrayList<>(Arrays.asList(serialisedTree.split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        List<String> result = DFSWithStates.ternaryTreePaths(tree);
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).equals("10->5"));
    }

    @Test
    void shouldReturnPathForTwoHeightFourNodeTree() {
        String serialisedTree = "10 3 4 0 5 0 6 0";
        List<String> listOfNodes = new ArrayList<>(Arrays.asList(serialisedTree.split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        List<String> result = DFSWithStates.ternaryTreePaths(tree);
        assertTrue(result.size() == 3);
        assertTrue(result.equals(Arrays.asList("10->4", "10->5", "10->6")));
    }

    @Test
    void shouldReturnPathForThreeHeightFiveNodeTree() {
        String serialisedTree = "1 2 11 2 111 0 112 0 12 0 ";
        List<String> listOfNodes = new ArrayList<>(Arrays.asList(serialisedTree.split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        List<String> result = DFSWithStates.ternaryTreePaths(tree);
        assertTrue(result.size() == 3);
        assertTrue(result.equals(Arrays.asList("1->11->111", "1->11->112", "1->12")));
    }


}