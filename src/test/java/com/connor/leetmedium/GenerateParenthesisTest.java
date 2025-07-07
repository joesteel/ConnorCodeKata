package com.connor.leetmedium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    @Test
    void shouldGenerateParenthesis() {
        assertArrayEquals(new String[] {"((()))","(()())","(())()","()(())","()()()"}, GenerateParenthesis.generateParenthesis(3).toArray());
        assertArrayEquals(new String[] {"()"}, GenerateParenthesis.generateParenthesis(1).toArray());
        assertArrayEquals(new String[] {"(())","()()"}, GenerateParenthesis.generateParenthesis(2).toArray());

    }
}