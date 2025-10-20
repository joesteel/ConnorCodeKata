package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    @Test
    void shouldPerformHashSetOperations() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        assertTrue(myHashSet.contains(1));    // returns true
        assertFalse(myHashSet.contains(3));   // returns false (not found)
        myHashSet.add(2);
        assertTrue(myHashSet.contains(2));    // returns true
        myHashSet.remove(2);
        assertFalse(myHashSet.contains(2));   // returns false (already removed)
    }
}