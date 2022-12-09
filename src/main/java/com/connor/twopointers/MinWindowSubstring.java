package com.connor.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinWindowSubstring{

    public static String getMinimumWindow(String original, String check) {
        int minWindowSize = check.length()-1;
        int maxWindowSize = original.length()-1;
        int rightPtr = minWindowSize;
        int windowSize = minWindowSize;
        String result = null;
        int[] encodedCheck = new int[150];
        for(int i = 0; i<check.length(); i++){
            encodedCheck[check.charAt(i)-'A']++;
        }

        while(rightPtr < original.length()){
            String window = original.substring(rightPtr-windowSize, rightPtr+1);
           if(stringContainsCheck(window, encodedCheck)){
                if(result == null || result.compareTo(window) > 0 || result.length() > window.length()) result = window;
                maxWindowSize = windowSize;
                if(windowSize > minWindowSize) windowSize--;
                else rightPtr++;
            } else {
                if(windowSize < maxWindowSize) windowSize++;
                rightPtr++;
            }
        }
        return result == null ? "" : result;
    }

    public static boolean stringContainsCheck(String str, final int[] encodedCheck){
        int[] checkCopy = Arrays.copyOf(encodedCheck, encodedCheck.length);
        for(int i = 0; i<str.length(); i++){
            if(checkCopy[str.charAt(i) - 'A'] > 0) {
                checkCopy[str.charAt(i) - 'A']--;
            } // if all entries of the check exist within the string then all entries in teh encodedCheck arr should be 0 (or less) at this point
        }
        int checkSum = 0;
        for(int i =0; i < encodedCheck.length; i++) checkSum += checkCopy[i];
        return checkSum <= 0;
    }

}
