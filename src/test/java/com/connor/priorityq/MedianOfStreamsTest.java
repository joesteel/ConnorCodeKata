package com.connor.priorityq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfStreamsTest {

    @Test
    void shouldReturnMedianOfStreamWith1Elemnt() {
        MedianOfStreams.MedianOfStream m = new MedianOfStreams.MedianOfStream();
        m.addNum(1);
        double result = m.getMedian();
        assertEquals(1, result);
    }

    @Test
    void shouldReturnMedianOfStreamWith2Elemnts() {
        MedianOfStreams.MedianOfStream m = new MedianOfStreams.MedianOfStream();
        m.addNum(1);
        m.addNum(3);
        double result = m.getMedian();
        assertEquals((1+3)/2, result);
    }

    @Test
    void shouldReturnMedianOfStreamWith3Elemnts() {
        MedianOfStreams.MedianOfStream m = new MedianOfStreams.MedianOfStream();
        m.addNum(1);
        m.addNum(10);
        m.addNum(3);
        double result = m.getMedian();
        assertEquals(3, result);
    }

    @Test
    void shouldReturnMedianOfStreamWith4Elemnts() {
        MedianOfStreams.MedianOfStream m = new MedianOfStreams.MedianOfStream();
        m.addNum(1);
        m.addNum(10);
        m.addNum(3);
        m.addNum(5);
        double result = m.getMedian();
        assertEquals(4, result);
    }


}