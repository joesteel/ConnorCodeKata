package com.connor.leeteasy;

public class MakeStringGreat {
    public static String makeGood(String s) {
        for(int i = 1; i < s.length(); i++){
            if(Math.abs( (int)s.charAt(i) - (int)s.charAt(i-1)) == 32) {
                if(i+1 < s.length()){
                    return makeGood(s.substring(0, i-1) + s.substring(i+1));
                } else {
                    return makeGood(s.substring(0, i-1));
                }
            }
        }
        return s;
    }
}
