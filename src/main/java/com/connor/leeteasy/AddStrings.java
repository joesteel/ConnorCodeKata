package com.connor.leeteasy;

import java.util.Arrays;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;

       while (i >= 0 || j >=0 || carry > 0){
           int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
           int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
           int val = digit1 + digit2 + carry;
           carry = val / 10;
           result.append((char)(val%10 + '0'));
        }

        return result.reverse().toString();
    }
}
