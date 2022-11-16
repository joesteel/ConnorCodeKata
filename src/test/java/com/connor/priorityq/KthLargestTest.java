package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void shouldReturn1stElementInListOfOne() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10));
        int result = KthLargest.findKthLargest(list, 1);
        assertEquals(10, result);
    }

    @Test
    void shouldReturnKthElementInListOfTwo() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 69));
        int result = KthLargest.findKthLargest(list, 2);
        assertEquals(10, result);
    }

    @Test
    void shouldReturnKthElementInListOfTen() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 69, 420, 1, 2 ,3,4 ,5, 600));
        int result = KthLargest.findKthLargest(list, 3);
        assertEquals(69, result);
    }
}