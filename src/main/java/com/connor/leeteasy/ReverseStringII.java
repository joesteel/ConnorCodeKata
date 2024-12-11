package com.connor.leeteasy;

public class ReverseStringII {

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int j = i + (k-1);
            j = j >= chars.length ? chars.length-1 : j;
            while( (i % (k*2) < k)){ // iterate through the open window
                // reverse string, swap position i with i + (k-1), then i+1 with i+1 (k-1)-(i+2), then i+2 with
                if(i < j) {
                    char t = chars[i];
                    chars[i] = chars[j];
                    chars[j] = t;
                }
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
