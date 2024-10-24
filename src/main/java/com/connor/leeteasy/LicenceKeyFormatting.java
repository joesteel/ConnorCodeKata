package com.connor.leeteasy;

import java.util.Arrays;
import java.util.StringJoiner;

public class LicenceKeyFormatting {

    public static String licenseKeyFormatting(String s, int k){
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = chars.length-1; i >= 0; ){
            int j = 0;
            while(i >= 0){
                if(j == k && chars[i] != '-'){
                    result.append('-');
                    break; // reset
                }
                if(chars[i] != '-'){
                    result.append(chars[i]);
                    j++;
                }
                i--;
            }
        }
        return result.reverse().toString().toUpperCase();
    }
}
