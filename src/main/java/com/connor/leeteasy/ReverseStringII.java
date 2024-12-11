package com.connor.leeteasy;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i+=k){
            int j = (i/k)+k-1;
            while(i % (k*2) < k){ // iterate through the open window
                // reverse string, swap position i with i + (k-1), then i+1 with i+1 (k-1)-(i+2), then i+2 with
                char t = chars[i];
                chars[i] = chars[j--];
                chars[j] = t;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
