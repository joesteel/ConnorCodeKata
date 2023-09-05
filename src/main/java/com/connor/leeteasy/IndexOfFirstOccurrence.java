package com.connor.leeteasy;

public class IndexOfFirstOccurrence {
    public static int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        char needleStart = needle.charAt(0);
        char[] ch = haystack.toCharArray();

        for(int i = 0; i <= haystack.length() - needleSize; i++){
            if(ch[i] == needleStart){
                if(haystack.substring(i, i+needleSize).equals(needle)) return i;
            }
        }
        return -1;
    }
}
