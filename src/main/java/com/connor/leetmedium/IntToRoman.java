package com.connor.leetmedium;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static String intToRoman(int num) {

        // put the availabe values in a map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");



        // put them in a list
        int[] roman_nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman_numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // iterate over the list
            // divide the input number for each value in the map... if it divides then append the result from the map
            // if we don't divide anymore move on to next num

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
