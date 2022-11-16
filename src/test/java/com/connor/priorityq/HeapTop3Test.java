package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapTop3Test {

    @Test
    void shouldReturnSmallest3ElementsFromAList() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(6, 8, 9, 4, 7, 5, 3, 1, 0, 7, 2));
        List<Integer> res = HeapTop3.heapTop3(arr);
        assertEquals(3, res.size());
        int i = 0;
        for(int e:res) {
            assertEquals(i, e);
            i++;
        }
    }
}