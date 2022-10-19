package com.connor.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, paths);
        return paths;
    }
    public static boolean isPalindrome(String string) {
        char[] reverse = new char[string.length()];
        for (int i = string.length()-1; i >= 0; i--) {
            reverse[string.length()-1-i] = string.charAt(i);
        }
        String revereStr = new String(reverse);
        return revereStr.equals(string);
    }

    public static void dfs(int startIndex, String string, List<String> path, List<List<String>> paths){
        if(startIndex == string.length()){
            paths.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i<string.length();i++){
            String prefix = string.substring(startIndex, i+1);
            if(isPalindrome(prefix)){
                path.add(prefix);
                dfs(i+1, string, path, paths);
                path.remove(path.size()-1);
            }
        }
    }

    public static void returnAllSubStrings(int startIndex, String string, List<String> substrings){
        if(startIndex == string.length()){
            return;
        }
        for(int i = startIndex; i<string.length();i++){
            substrings.add(string.substring(startIndex, i+1));
            returnAllSubStrings(i+1, string, substrings);
        }
    }

}
