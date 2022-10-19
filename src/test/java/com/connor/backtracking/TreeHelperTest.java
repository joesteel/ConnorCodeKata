package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TreeHelperTest {

    @Test
    void shouldDeSerializeATreeWithOneNode() {
        Node<Integer> tree = new Node<>(10);
        String result = TreeHelper.serializeTree(tree, Object::toString);
        String expectedResult = "10 0 ";
        assertTrue(result.compareTo(expectedResult) == 0);
    }

    @Test
    void shouldSerializeATreeWithOneNode() {
        List<String> listOfNodes = new ArrayList<>(Arrays.asList("10 0 ".split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        assertEquals(10, tree.val);
        assertEquals(0, tree.children.size());
    }


    @Test
    void shouldSerializeATreeOfHeightTwo() {
        List<String> listOfNodes = new ArrayList<>(Arrays.asList("10 3 1 0 2 0 3 0 ".split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        assertEquals(10, tree.val);
        List<Node<Integer>> level1 = tree.children;
        assertEquals(3, level1.size());
        for(int i = 0; i < level1.size(); i++){
            assertEquals(i+1, level1.get(i).val);
            assertEquals(0, level1.get(i).children.size());
        }
    }

    @Test
    void shouldDeSerializeATreeOfHeightTwo() {
        String expectedResult = "10 3 1 0 2 0 3 0 ";
        List<String> listOfNodes = new ArrayList<>(Arrays.asList(expectedResult.split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        assertTrue(TreeHelper.serializeTree(tree, Objects::toString).equals(expectedResult));
    }

    @Test
    void shouldSerializeAndDeSerializeATreeOfHeightThree() {
        String expectedResult = "10 1 12 1 15 0 ";
        List<String> listOfNodes = new ArrayList<>(Arrays.asList(expectedResult.split(" "))) ;
        Node<Integer> tree = TreeHelper.deserializeTree(listOfNodes.iterator(), Integer::parseInt);
        assertTrue(TreeHelper.serializeTree(tree, Objects::toString).equals(expectedResult));
    }

}