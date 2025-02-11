package com.connor.leeteasy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentAttendanceRecordTest {

    @Test
    void shouldDetermineEligible() {
        assertFalse(StudentAttendanceRecord.checkRecord("AA"));
        assertFalse(StudentAttendanceRecord.checkRecord("PPAPLLL"));
        assertTrue(StudentAttendanceRecord.checkRecord("PPALLPPLPLLPP"));
        assertFalse(StudentAttendanceRecord.checkRecord("PPALLAP"));
        assertFalse(StudentAttendanceRecord.checkRecord("PPALLLP"));
        assertTrue(StudentAttendanceRecord.checkRecord("PPALLP"));
        assertTrue(StudentAttendanceRecord.checkRecord("A"));
        assertTrue(StudentAttendanceRecord.checkRecord("LL"));
    }
}