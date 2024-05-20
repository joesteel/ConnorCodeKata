package com.connor.leeteasy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        // it's actually possible to do this with one hashmap... you need to check if you already have a match and if you do is it the same one as previous
        Map<Integer, String> pattern_index = new HashMap<>();
        Map<String, Integer> work_index = new HashMap<>();

        String[] stringList = s.split(" ");
        if(stringList.length != pattern.length()) return false;
        for(int i = 0; i < stringList.length; i++){
            pattern_index.putIfAbsent((int)pattern.charAt(i), stringList[i]);
            work_index.putIfAbsent(stringList[i], (int)pattern.charAt(i));
            if(!pattern_index.get((int)pattern.charAt(i)).equals(stringList[i])) return false;
            if(work_index.get(stringList[i]) != (int)pattern.charAt(i)) return false;
        }
        return true;
    }
}
