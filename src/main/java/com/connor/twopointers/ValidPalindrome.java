package com.connor.twopointers;


import java.util.stream.Collectors;


public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        String cleanedInput = s.codePoints()
                .mapToObj(c -> (char) c)
                .filter(c->Character.isLetterOrDigit(c))
                .map(String::valueOf)
                .map(String::toLowerCase)
                .collect(Collectors.joining());
        int left = 0, right = cleanedInput.length()-1;
        while(left < right){
            if(!cleanedInput.substring(left, left+1).equals(cleanedInput.substring(right, right+1))){
                return false;
            }
            left++; right--;
        }
        return true;
    }


    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length()-1;
        while(left < right){
            if(!s.substring(left, left+1).equals(s.substring(right, right+1))){
                return false;
            }
            left++; right--;
        }
        return true;
    }


}
