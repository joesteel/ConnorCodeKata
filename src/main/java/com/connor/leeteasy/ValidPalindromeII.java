package com.connor.leeteasy;

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        return isPalindromeAfterSkips(s.toCharArray(), 0, s.length()-1, 1);
    }

    private static boolean isPalindromeAfterSkips(char[] chars, int left, int right, int skipsRemaining){
        if(skipsRemaining < 0) return false;
        while(left < right){
            if(chars[left] != chars[right])
                return isPalindromeAfterSkips(chars, left+1, right, skipsRemaining-1) ||
                        isPalindromeAfterSkips(chars, left, right-1, skipsRemaining-1);
            left++; right--;
        }
        return true;
    }
}
