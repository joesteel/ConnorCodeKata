package com.connor.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    public static String digitsToLetters(int n){
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int start = 0;
        int end = 0;
        switch (n) {
            case 7 : {
                start = (n-2)*3;
                end = start+4;
                break;
            }
            case 8 : {
                start = (n-3)*3 + 4;
                end = start+3;
                break;
            }
            case 9 : {
                start = 22;
                end = start+4;
                break;
            }
            default:{
                start = (n-2)*3;
                end = start+3;
            }
        }
        return alphabet.substring(start, end);
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, digits.length(), digits, path, results);
        return results;
    }

    public static void dfs(int layer, int maxLayer, String digits, List<String> path, List<String> results){
        if(layer == maxLayer) { // I'm a leaf
            results.add(String.join("", path));
            return;
        }
        int digit = Integer.parseInt(digits.substring(layer, layer+1));
        char[] edges = PhoneNumber.digitsToLetters(digit).toCharArray();
        for(char edge: edges){
            path.add(String.valueOf(edge));
            dfs(layer+1, maxLayer, digits, path, results);
            path.remove(path.size()-1);
        }
    }
}
