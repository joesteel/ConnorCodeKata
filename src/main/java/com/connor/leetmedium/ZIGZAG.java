package com.connor.leetmedium;

public class ZIGZAG {
    public static String convert(String s, int numRows) {
        char[] result = new char[s.length()];
        final int colOffset = numRows + (numRows - 2);
        int rPtr = 0;

        for(int row = 0; row < numRows; row++){
            int currentColumnIndex = row;
            int currentDiagonalIndex = colOffset-row;
            while(currentColumnIndex < s.length()){
                result[rPtr++] = s.charAt(currentColumnIndex);
                if(row > 0 && row < numRows-1 && currentDiagonalIndex < s.length()){
                    result[rPtr++] = s.charAt(currentDiagonalIndex);
                    currentDiagonalIndex += colOffset;
                }
                currentColumnIndex += colOffset;
            }
        }

        return new String(result);
    }
}
