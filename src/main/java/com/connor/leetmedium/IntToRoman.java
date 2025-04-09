package com.connor.leetmedium;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static String intToRoman(int num) {
        int[] roman_nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman_numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < roman_numerals.length; i++){
            while(num/roman_nums[i] > 0) {
                result.append(roman_numerals[i]);
                num -= roman_nums[i];
            }
        }
        return result.toString();
    }
}
