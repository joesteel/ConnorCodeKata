package com.connor.twopointers;

import java.util.HashSet;

public class LongestSubstring {

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> usedChars = new HashSet<>();
        int ptr1 = 0, ptr2 = 0, longestSubStr = 0;
        while(ptr2 < chars.length){
            if(usedChars.contains(chars[ptr2])){
                usedChars.remove(chars[ptr1]);
                ptr1++;
            } else {
                usedChars.add(chars[ptr2]);
                ptr2++;
            }
            longestSubStr = Math.max(longestSubStr, ptr2-ptr1);
        }
        return longestSubStr;
    }
}
