package com.connor.leeteasy;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        while(r < chars.length){
            if(chars[r] == ' '){
                reverseChars(chars, l, r-1);
                r++;
                l=r;
            } else r++;
        }
        if(l < r) reverseChars(chars, l, r-1);
        return new String(chars);
    }

    private static void reverseChars(char[] chars, int start, int end){
        if(end > chars.length || start < 0) return;
        while(end > start){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            end--;start++;
        }
    }
}
