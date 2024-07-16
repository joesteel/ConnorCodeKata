package com.connor.leeteasy;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        int[] frequencyMap = new int[26];
        char[] chars = s.toCharArray();
        for(char c: chars) {
            frequencyMap[c - 'a'] += 1;
        }
        for(int i = 0; i < chars.length; i++) {
            if(frequencyMap[chars[i] -'a'] == 1) return i;
        }
        return -1;
    }
}
