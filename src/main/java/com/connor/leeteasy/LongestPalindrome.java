package com.connor.leeteasy;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] frequency = new int[58];
        int result = 0;
        for(char c: s.toCharArray()){
            if(frequency[c-'A'] == 1) {
                result += 2;
                frequency[c-'A'] = 0;
            } else frequency[c-'A'] = 1;
        }

        for (int i: frequency) {
            if(i == 1) {
                result += 1;
                break;
            }
        }
        return result;
    }
}
