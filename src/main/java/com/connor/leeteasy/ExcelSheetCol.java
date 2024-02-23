package com.connor.leeteasy;

public class ExcelSheetCol {
    public static String convertToTitle(int columnNumber) {
        // represent the number as x * 26^0 + y * 26^1 + z *26^2 etc... x,y,z [1...26]
        int remainder = columnNumber;
        int highest_power = (int) customLog(26, remainder);
        if(highest_power > 0 && (remainder / (int)Math.pow(26, highest_power-1) == 26)) highest_power--;
        char[] cols = new char[highest_power+1];
        while(highest_power >= 0){
            int x = 26;
            while(remainder - x * (int)Math.pow(26, highest_power) < 0){
                x--;
            }
            remainder = remainder - x * (int)Math.pow(26, highest_power);
            cols[cols.length -1 - highest_power] = (char)(x+65-1);
            highest_power--;
        }
        return new String(cols);
    }

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}