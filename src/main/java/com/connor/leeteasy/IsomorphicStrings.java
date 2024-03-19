package com.connor.leeteasy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Integer, Integer> iso_lookup = new HashMap<>();
        HashSet<Integer> used_chars = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(iso_lookup.get((int) s.charAt(i)) == null) {
                if(used_chars.contains((int) t.charAt(i))) return false;
                iso_lookup.put((int) s.charAt(i), (int) t.charAt(i));
                used_chars.add((int) t.charAt(i));
            } else if (iso_lookup.get((int) s.charAt(i)) != null) {
                if (iso_lookup.get((int) s.charAt(i)) != (int) t.charAt(i)) return false;
            }
        }
        return true;
    }
}
