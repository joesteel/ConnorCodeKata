package com.connor.leeteasy;

public class ExcelSheetCol {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int power = 0;
        while(columnNumber > 26){
            int r2 = columnNumber;
            power = 0;
            while(r2 > 26) {
                power++;
                r2 = r2/26;
            }
            result.append((char)(r2+64));
            i++;
            columnNumber = columnNumber - (r2 * (int)Math.pow(26, power));
        }
        if(columnNumber == 0) {
            while(power > 0) {
                result.append('A');
                power--;
            }
        } else result.append((char)(64+columnNumber));
        return result.toString();
    }
}