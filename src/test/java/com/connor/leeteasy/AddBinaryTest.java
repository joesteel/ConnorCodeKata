package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    @Test
    void shouldAdd0and0() {
        String a = "0";
        String b = "0";
        String c = AddBinary.addBinary(a,b);
        assertEquals("0", c);
    }

    @Test
    void shouldAdd0and1() {
        String a = "0";
        String b = "1";
        String c = AddBinary.addBinary(a,b);
        assertEquals("1", c);
    }
    @Test
    void shouldAdd1and1() {
        String a = "1";
        String b = "1";
        String c = AddBinary.addBinary(a,b);
        assertEquals("10", c);
    }

    @Test
    void shouldAdd4and8() {
        String a = "100";
        String b = "1000";
        String c = AddBinary.addBinary(a,b);
        assertEquals("1100", c);
    }

    @Test
    void shouldAdd8and8() {
        String a = "1000";
        String b = "1000";
        String c = AddBinary.addBinary(a,b);
        assertEquals("10000", c);
    }

    @Test
    void shouldAdd8and9() {
        String a = "1001";
        String b = "1000";
        String c = AddBinary.addBinary(a,b);
        assertEquals("10001", c);
    }

    @Test
    void shouldAdd7and7() {
        String a = "111";
        String b = "111";
        String c = AddBinary.addBinary(a,b);
        assertEquals("1110", c);
    }

}