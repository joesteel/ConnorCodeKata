package com.connor.leeteasy;

public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        // another approach is to sum all the int values of s and take away all the values of t....
        // then you're left with the remaining char
        char result = 'z';
        int[] frequencyMap = new int[26];
        for (char c : s.toCharArray())
            frequencyMap[c - 'a'] += 1;
        for (char c : t.toCharArray()) {
            if (frequencyMap[c - 'a'] == 0) {
                result = c;
                break;
            }
            frequencyMap[c - 'a'] -= 1;
        }
        return result;
    }

}
