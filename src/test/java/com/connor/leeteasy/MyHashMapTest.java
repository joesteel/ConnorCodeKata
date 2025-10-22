package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void shouldPerformHashMapOperations() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        assertEquals(1, myHashMap.get(1));    // returns 1
        assertEquals(-1, myHashMap.get(3));   // returns -1 (not found)
        myHashMap.put(2, 1);                   // update the existing value
        assertEquals(1, myHashMap.get(2));    // returns 1
        myHashMap.remove(2);                   // remove the mapping for 2
        assertEquals(-1, myHashMap.get(2));   // returns -1 (not found)
    }
}