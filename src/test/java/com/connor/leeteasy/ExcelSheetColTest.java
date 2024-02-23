package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelSheetColTest {

    @Test
    void shouldReturnColSingle() {
        String result = ExcelSheetCol.convertToTitle(1);
        assertEquals("A", result);
    }

    @Test
    void shouldReturnColSingleA() {
        String result = ExcelSheetCol.convertToTitle(24);
        assertEquals(result, "X");
    }

    @Test
    void shouldReturnColSingleZ() {
        String result = ExcelSheetCol.convertToTitle(26);
        assertEquals(result, "Z");
    }

    @Test
    void shouldReturnColDoubleAA() {
        String result = ExcelSheetCol.convertToTitle(27);
        assertEquals("AA", result);
    }


    @Test
    void shouldReturnColAZ() {
        String result = ExcelSheetCol.convertToTitle(702);
        assertEquals("ZZ", result);
    }
    @Test
    void shouldReturnColAAA() {
        String result = ExcelSheetCol.convertToTitle(703);
        assertEquals("AAA", result);
    }

    @Test
    void shouldReturnColDoubleBA() {
        String result = ExcelSheetCol.convertToTitle(52);
        assertEquals("AZ", result);
    }

    @Test
    void shouldReturnColDoubleZY() {
        String result = ExcelSheetCol.convertToTitle(701);
        assertEquals("ZY", result);
    }

    @Test
    void shouldReturnColDoubleAAA() {
        String result = ExcelSheetCol.convertToTitle(704);
        assertEquals("AAB", result);
    }
}