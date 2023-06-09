package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    @Test
    void shouldMatchBasic1() {
        assertTrue(ValidParenthesis.isValid("()"));
    }

    @Test
    void shouldMatchBasic2() {
        assertTrue(ValidParenthesis.isValid("[]"));
    }

    @Test
    void shouldMatchBasic3() {
        assertTrue(ValidParenthesis.isValid("{}"));
    }

    @Test
    void shouldMatchSequenced() {
        assertTrue(ValidParenthesis.isValid("()()()[][][]{}{}{}"));
    }

    @Test
    void shouldMatchNested() {
        assertTrue(ValidParenthesis.isValid("([{()}])"));
    }

    @Test
    void shouldMatchSequencedAndNested() {
        assertTrue(ValidParenthesis.isValid("([{}[]()])"));
    }

    @Test
    void shouldFailBasic() {
        assertFalse(ValidParenthesis.isValid("(]"));
    }

    @Test
    void shouldFailSequence() {
        assertFalse(ValidParenthesis.isValid("()[]{)"));
    }

}