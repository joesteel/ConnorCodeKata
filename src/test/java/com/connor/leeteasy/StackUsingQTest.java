package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingQTest {

    @Test
    void shouldInitialiseAndPushTop() {
        StackUsingQ s = new StackUsingQ();
        s.push(1);
        assertEquals(1, s.top());
        s.push(2);
        assertEquals(2, s.top());
    }
}