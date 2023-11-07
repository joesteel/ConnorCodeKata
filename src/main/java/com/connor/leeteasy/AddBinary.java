package com.connor.leeteasy;

import java.util.Arrays;

public class AddBinary {

    public static String addBinary(String a, String b) {
        String longer;
        String shorter;
        if(a.length() > b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        int offset = longer.length() - shorter.length();
        int overflow = 0;
        char[] result = new char[longer.length()];
        for(int i = longer.length()-1; i>=0; i--) {
            int sum = (i - offset >= 0) ? (int)longer.charAt(i) + (int)shorter.charAt(i-offset) + overflow : (int)longer.charAt(i) + (int)'0' + overflow;
            switch (sum) {
               case 96:
                   overflow = 0;
                   result[i] = '0';
                   break;
               case 97:
                   overflow = 0;
                   result[i] = '1';
                   break;
               case 98:
                   overflow = 1;
                   result[i] = '0';
                   break;
               case 99:
                   overflow = 1;
                   result[i] = '1';
                   break;
               default:
                   return "ERROR";
            }
        }
        if(overflow == 1) {
            char[] overflowResult = new char[result.length + 1];
            System.arraycopy(result, 0, overflowResult,1, result.length);
            overflowResult[0] = '1';
            return new String(overflowResult);
        }
        return new String(result);
    }
}
