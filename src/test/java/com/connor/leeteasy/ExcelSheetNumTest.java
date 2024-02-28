package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelSheetNumTest {

    @Test
    void shouldDoA() {
        int result = ExcelSheetNum.titleToNumber("A");
        assertEquals(1, result);
    }

    @Test
    void shouldDoZ() {
        int result = ExcelSheetNum.titleToNumber("Z");
        assertEquals(26, result);
    }

    @Test
    void shouldDoAA() {
        int result = ExcelSheetNum.titleToNumber("AA");
        assertEquals(27, result);
    }

    @Test
    void shouldDoZA() {
        int result = ExcelSheetNum.titleToNumber("ZA");
        assertEquals(677, result);
    }

    @Test
    void shouldDoZY() {
        int result = ExcelSheetNum.titleToNumber("ZY");
        assertEquals(701, result);
    }

    @Test
    void shouldDoAAB() {
        int result = ExcelSheetNum.titleToNumber("AAB");
        assertEquals(704, result);
    }
}