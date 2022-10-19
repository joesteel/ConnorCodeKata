package com.connor.backtracking;

import java.util.HashMap;
import java.util.Map;

public class WaysToDecodeMessage {

    public static int decodeWays(String digits) {
        return dfs(0, digits, new Integer[digits.length()]);
    }

    public static int dfs(int startIndex, String digits, Integer[] memo){
        if(startIndex >= digits.length()){
            return 1;
        }
        if(memo[startIndex] != null) return memo[startIndex];

        int result = 0;
        for(int i=1; i<26; i++){ //can I get rid of the while 26 no ops thing?
            if(digits.substring(startIndex).startsWith(String.valueOf(i))){
                result += dfs(startIndex+String.valueOf(i).length(), digits, memo);
            }
        }
        memo[startIndex] = result;
        return result;
    }

}
