package com.connor.leeteasy;

public class StudentAttendanceRecord {
    public static boolean checkRecord(String s) {
        char[] attendance_records = s.toCharArray();
        int absent_days = 0;
        int consecutive_late_days = 0;
        for(char record: attendance_records){
            switch(record) {
                case('A') :
                    absent_days++;
                    consecutive_late_days = 0;
                    break;
                case('L'):
                    consecutive_late_days++;
                    break;
                default:
                    consecutive_late_days = 0;
            }
            if(absent_days >= 2 || consecutive_late_days >= 3) return false;
        }
        return true;
    }
}
