package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class thLargestTest {

    @Test
    void shouldReturnKthLargest() {
        KthLargest kthLargest = new KthLargest(3, new int[] {4,5,8,2});
        assertEquals(4, kthLargest.add(3)); // 4,5,8
        assertEquals(4, kthLargest.add(2));  // 4, 5, 8
        assertEquals(5, kthLargest.add(6));   // 5, 6, 8
        assertEquals(6, kthLargest.add(7));   // 6, 7, 8
        assertEquals(7, kthLargest.add(10));   // 7, 8, 10
        assertEquals(8, kthLargest.add(9));   // 8, 9 ,10
    }

    @Test
    void shouldReturnKthLargestWhenKLargerThanNums(){
        KthLargest kthLargest = new KthLargest(5, new int[] {4,5,8,2});
        assertEquals(2, kthLargest.add(3)); // 2,3,4,5,8
    }

}