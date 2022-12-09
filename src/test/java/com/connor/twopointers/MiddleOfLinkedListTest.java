package com.connor.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfLinkedListTest {

    @Test
    void shouldBuildALinkListFromAString() {
        String serializedList = "1";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        assertTrue(node.val == 1);
        assertTrue(node.next == null);
    }

    @Test
    void shouldBuildALinkListFromAString_2() {
        String serializedList = "1 2";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        assertTrue(node.val == 1);
        assertTrue(node.next.val == 2);
        assertTrue(node.next.next == null);
    }

    @Test
    void shouldBuildALinkListFromAString_3() {
        String serializedList = "1 2 3 4 5";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        assertTrue(node.val == 1);
        assertTrue(node.next.val == 2);
        assertTrue(node.next.next.val == 3);
        assertTrue(node.next.next.next.val == 4);
        assertTrue(node.next.next.next.next.val == 5);
        assertTrue(node.next.next.next.next.next == null);
    }

    @Test
    void shouldFindMiddleOf3ElementLL() {
        String serializedList = "1 2 3";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        int result = MiddleOfLinkedList.middleOfLinkedList(node);
        assertEquals(2, result);
    }

    @Test
    void shouldFindMiddleOf4ElementLL() {
        String serializedList = "1 2 3 4";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        int result = MiddleOfLinkedList.middleOfLinkedList(node);
        assertEquals(2, result);
    }

    @Test
    void shouldFindMiddleOf1ElementLL() {
        String serializedList = "1";
        MiddleOfLinkedList.Node<Integer> node = MiddleOfLinkedList.buildList(Arrays.stream(serializedList.split(" ")).iterator(), Integer::parseInt);
        int result = MiddleOfLinkedList.middleOfLinkedList(node);
        assertEquals(1, result);
    }

}