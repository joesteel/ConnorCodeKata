package com.connor.leeteasy;

public class ExcelSheetNum {
    public static int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int total = 0;
        int j = 0;
        for(int i = arr.length-1; i>=0; i--){
            int component = ((int)arr[i] - 64) * (int)Math.pow(26, j);
            total = total + component;
            j++;
        }
        return total;
    }
}
