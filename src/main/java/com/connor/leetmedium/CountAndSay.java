package com.connor.leetmedium;

public class CountAndSay {

    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String previous = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int p1 = 0, p2 = 0;

        // iterate through previous result....
        while(p2 <= previous.length()) {
            if(p2 == previous.length() || previous.charAt(p1) != previous.charAt(p2)) {
                result.append(p2 - p1).append(previous.charAt(p1));
                p1 = p2;
            }
            p2++;
        }
        return result.toString();
    }

}
