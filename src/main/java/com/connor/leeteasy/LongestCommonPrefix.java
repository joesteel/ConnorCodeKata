package com.connor.leeteasy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        int prefixEnd = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            prefixEnd = Math.min(prefixEnd, strs[i].length());
            while(!strs[0].substring(0, prefixEnd).equals(strs[i].substring(0, prefixEnd))) {
                prefixEnd--;
                if(prefixEnd < 1) break;
            }
        }
        return strs[0].substring(0, prefixEnd);
    }
}
