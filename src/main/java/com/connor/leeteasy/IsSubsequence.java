package com.connor.leeteasy;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int s_len = s.length(), t_len = t.length(), s_ptr = 0, t_ptr = 0;
        char[] s_chars = s.toCharArray(), t_chars = t.toCharArray();
        while (s_ptr < s_len && t_ptr < t_len){
            if(s_chars[s_ptr] == t_chars[t_ptr]) {
                s_ptr += 1;
            }
            t_ptr += 1;
        }
        return s_ptr == s_len;
    }
}
