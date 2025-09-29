package com.connor.leeteasy;

public class CountBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        int result = 0;
        int ptr = 0;
        char[] chars = s.toCharArray();
        while (ptr < chars.length-1) {
            if(chars[ptr] != chars[ptr+1]) {
                result++;
                int l = ptr-1;
                int r = ptr+2;
                while (l >= 0 && r < chars.length && chars[l] == chars[ptr] && chars[r] == chars[ptr+1]) {
                    result++;
                    l--;r++;
                }
            }
            ptr++;
        }
        return result;
    }
}
