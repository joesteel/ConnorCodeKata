package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryWatchTest {

    @Test
    void shouldReturn0For0bits() {
        BinaryWatch bw = new BinaryWatch();
        List<String> results = bw.readBinaryWatch(0);
        assertEquals(1, results.size());
        assertEquals("0:00", results.get(0));
    }

    @Test
    void shouldReturnFor1bits() {
        BinaryWatch bw = new BinaryWatch();
        List<String> results = bw.readBinaryWatch(1);
        assertEquals("1:00", results.get(0));
        assertEquals("0:32", results.get(9));
    }

    @Test
    void shouldReturnFor2bits() {
        BinaryWatch bw = new BinaryWatch();
        List<String> results = bw.readBinaryWatch(2);
    }

    @Test
    void shouldReturnEmptyFor9bits() {
        BinaryWatch bw = new BinaryWatch();
        List<String> results = bw.readBinaryWatch(9);
        assertEquals(0, results.size());
    }
}