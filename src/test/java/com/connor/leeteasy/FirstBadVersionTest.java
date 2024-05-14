package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    @Test
    void shouldFindFirstBadVersion_last() {
        int badVersion = 3;
        FirstBadVersion fbv = new FirstBadVersion(badVersion);
        int result = fbv.firstBadVersion(3);
        assertEquals(badVersion, result);
    }

    @Test
    void shouldFindFirstBadVersion_first() {
        int badVersion = 1;
        FirstBadVersion fbv = new FirstBadVersion(badVersion);
        int result = fbv.firstBadVersion(3);
        assertEquals(badVersion, result);
    }

    @Test
    void shouldFindFirstBadVersion_second() {
        int badVersion = 2;
        FirstBadVersion fbv = new FirstBadVersion(badVersion);
        int result = fbv.firstBadVersion(5);
        assertEquals(badVersion, result);
    }

    @Test
    void shouldFindFirstBadVersion_middle() {
        int badVersion = 5;
        FirstBadVersion fbv = new FirstBadVersion(badVersion);
        int result = fbv.firstBadVersion(10);
        assertEquals(badVersion, result);
    }
}