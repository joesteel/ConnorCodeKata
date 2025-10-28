package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToLowerCaseTest {

@Test
void shouldConvertToLowerCase() {
        ToLowerCase toLowerCase = new ToLowerCase();
        String input = "Hello World!";
        String expected = "hello world!";
        String result = toLowerCase.toLowerCase(input);
        assertEquals(expected, result);
    }

}