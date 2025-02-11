package com.connor.leetmedium;

public class LongestPalindromicSubstring {
    static int max;
    static int longest_pal_start;
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int l = 0, r = 0;
        max = 0;
        longest_pal_start = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length-1; i++){
            l = i; r = i;
            expandAroundCentre(l,r,chars);
            expandAroundCentre(l,r+1,chars);
        }
        return s.substring(longest_pal_start, longest_pal_start+max);
    }

    private static void expandAroundCentre(int l, int r, char[] chars){
        while(l >= 0 && r < chars.length && (chars[l]) == chars[r]){
            if(r-l+1 > max){
                max = r-l+1;
                longest_pal_start = l;
            }
            r += 1; l -= 1;
        }
    }

    // option 2: chop up the string into every possible substr and see if any of those are a palindrome
    // brute force that sheeeit
    // each starting to end point pair can be considered as a nxn square... then check every single one

    // option 3: same as 2 but keep some state

}
