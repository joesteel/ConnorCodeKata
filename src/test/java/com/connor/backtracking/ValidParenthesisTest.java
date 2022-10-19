package com.connor.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {
    @Test
    void shouldDetectInvalidParenthesisPattern() {
        String pStream = "( () ) )";
        assertEquals(false, ValidParenthesis.isValidParenthesisStream(pStream));
    }

    @Test
    void shouldDetectValidParenthesisPattern() {
        String pStream = "( () ) ";
        assertEquals(true, ValidParenthesis.isValidParenthesisStream(pStream));
    }

    @Test
    void shouldDetectValidParenthesisPattern1() {
        String pStream = "() () ( ( () () ) ) ";
        assertEquals(true, ValidParenthesis.isValidParenthesisStream(pStream, true));
    }

    @Test
    void shouldDetectValidParenthesisPattern2() {
        String pStream = "() () ( ( () ( ";
        assertEquals(true, ValidParenthesis.isValidParenthesisStream(pStream));
    }

    @Test
    void shouldDetectIfNotEnoughSpaceLeftToComplete() {
        String pStream = "((((";
        assertEquals(false, ValidParenthesis.hasEnoughSpaceToCompletePattern(pStream, 3));
    }

    @Test
    void shouldDetectIfEnoughSpaceLeftToComplete() {
        String pStream = "(( )";
        assertEquals(true, ValidParenthesis.hasEnoughSpaceToCompletePattern(pStream, 1));
    }


    @Test
    void shouldGenerateAllValidParenthesisFor2() {
        assertTrue(ValidParenthesis.generateParentheses(2).equals(Arrays.asList("(())", "()()")));
    }


    @Test
    void shouldGenerateAllValidParenthesisFor3() {
        assertTrue(ValidParenthesis.generateParentheses(3).equals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

    @Test
    void shouldGenerateAllValidParenthesisFor1Easy() {
        assertTrue(ValidParenthesis.generateParentheses(1, "easy").equals(Arrays.asList("()")));
    }

    @Test
    void shouldGenerateAllValidParenthesisFor2Easy() {
        assertTrue(ValidParenthesis.generateParentheses(2, "easy").equals(Arrays.asList("(())", "()()")));
    }

    @Test
    void shouldGenerateAllValidParenthesisFor3Easy() {
        assertTrue(ValidParenthesis.generateParentheses(3, "easy").equals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

}