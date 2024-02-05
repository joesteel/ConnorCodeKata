package com.connor.leeteasy;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char[] chars = s.toLowerCase().toCharArray();
        while(l < r) {
            if( ((int)chars[l] < 97 || (int)chars[l] > 122) && ((int)chars[l] < 48 || (int)chars[l] > 57)) {
                l++;
                continue;
            }
            if( ((int)chars[r] < 97 || (int)chars[r] > 122) && ((int)chars[r] < 48 || (int)chars[r] > 57)){
                r--;
                continue;
            }
            if(chars[l] != chars[r]) return false;
            l++;r--;
        }
        return true;
    }
}
