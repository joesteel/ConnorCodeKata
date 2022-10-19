package com.connor.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> words) {
        return wordBreak(s, words, "slow way");
    }
    public static boolean wordBreak(String s, List<String> words, String type) {
        switch (type){
            case "slow way":
                return dfs(s, words, new ArrayList<>());
            case "memo" :
                boolean[] memo = new boolean[s.length()];
                Arrays.fill(memo, true);
                return dfsMemoized(0, s, words, memo);
            default:
                return dfs(0, s, words);
        }
    }

    public static boolean dfs(String s, List<String> words, List<String> path){
        if(String.join("", path).length() >= s.length()){
            return (String.join("", path).equals(s));
        }
        boolean found = false;
        for (String w: words){
            path.add(w);
            if(dfs(s, words, path)){
                found = true;
                break;
            }
            else path.remove(path.size()-1);
        }
        return found;
    }

    public static boolean dfs(int startIndex, String s, List<String> words){
        if(startIndex == s.length()){
            return true;
        }
        boolean ans = false;
        for(int i = startIndex; i < s.length(); i++){
            String prefix = s.substring(startIndex, i+1);
            if(words.contains(prefix)){
                ans = ans || dfs(i+1, s, words);
            }
        }
        return ans;
    }

    public static boolean dfsMemoized(int startIndex, String s, List<String> words, boolean[] memo){
        if(startIndex >= s.length()){
            return true;
        }
        boolean ans = false;
        for(String word:words){
            if(memo[startIndex]){
                if(s.substring(startIndex).startsWith(word)){
                    ans = (ans || dfsMemoized(startIndex+word.length(), s, words, memo));
                }
                if(ans) break;
            }
        }
        memo[startIndex] = ans;
        return ans;
    }

}
