package com.connor.leetmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsPhone {
    public static List<String> letterCombinations(String digits) {
        List<List<Character>> letterMappings = new ArrayList<>();
        // can simplify this map to just an array of strings...
        letterMappings.add(Arrays.asList('a', 'b', 'c'));
        letterMappings.add(Arrays.asList('d', 'e', 'f'));
        letterMappings.add(Arrays.asList('g', 'h', 'i'));
        letterMappings.add(Arrays.asList('j', 'k', 'l'));
        letterMappings.add(Arrays.asList('m', 'n', 'o'));
        letterMappings.add(Arrays.asList('p', 'q', 'r', 's'));
        letterMappings.add(Arrays.asList('t', 'u', 'v'));
        letterMappings.add(Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        if(!digits.isEmpty()) buildLetterCombinations(digits.toCharArray(), letterMappings, new StringBuilder(), result, 0);
        return result;
    }

    private static void buildLetterCombinations(char[] digits, List<List<Character>> letterMappings, StringBuilder path, List<String> result,int digit_index){
        if(digit_index >= digits.length) {
            result.add(path.toString());
            return;
        }

        int digit = digits[digit_index]-2-48; // correct for char int value and correct for offset of 2
        List<Character> children = letterMappings.get(digit);
        for(Character c: children){
            path.append(c);
            buildLetterCombinations(digits, letterMappings, path, result, digit_index+1);
            path.deleteCharAt(path.length()-1);
        }
    }

}
