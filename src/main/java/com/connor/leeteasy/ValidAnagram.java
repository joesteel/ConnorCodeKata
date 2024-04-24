package com.connor.leeteasy;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] frequencyMap = new int[26];
        for (int i = 0; i < s.length(); i++){
            frequencyMap[s.charAt(i) - 'a'] += 1;
            frequencyMap[t.charAt(i) - 'a'] -= 1;
        }
        for(int c : frequencyMap)
            if(c != 0) return false;
        return true;
    }
}
