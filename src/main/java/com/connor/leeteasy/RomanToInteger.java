package com.connor.leeteasy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        s = s.toLowerCase();

        Map<String, Integer> lookup = new HashMap<String, Integer>();
        lookup.put("i", 1);
        lookup.put("iv", 4);
        lookup.put("v", 5);
        lookup.put("ix", 9);
        lookup.put("x", 10);
        lookup.put("xl", 40);
        lookup.put("l", 50);
        lookup.put("xc", 90);
        lookup.put("c", 100);
        lookup.put("dc", 400);
        lookup.put("d", 500);
        lookup.put("cm", 900);
        lookup.put("m", 1000);

        int result = 0;
        for(int ptr = 0; ptr < s.length(); ptr++){
            if(ptr < s.length()-1 && lookup.get(s.substring(ptr,ptr+2)) != null) {
                result += lookup.get(s.substring(ptr,ptr+2));
                ptr++;
            } else result += lookup.get(s.substring(ptr, ptr+1));
        }
        return result;
    }

}
