package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int ptrL = 0, ptrR =s.length()-1;
        while(ptrL < ptrR) {
            if(s.charAt(ptrL) != s.charAt(ptrR)) return false;
            ptrL++; ptrR--;
        }
        return true;
    }

    public static boolean isPalindromeIntArray(int x) {
        List<Integer> array = new ArrayList<>(x);
        int n = 1, numAtPos = 0;
        while(x > 0) {
            numAtPos = x % (int)Math.pow(10, n);
            array.add(numAtPos/(int)Math.pow(10, n-1));
            x = x - numAtPos;
            n++;
        }
        int ptrL = 0, ptrR =array.size()-1;
        while(ptrL < ptrR) {
            if(array.get(ptrL) != array.get(ptrR)) return false;
            ptrL++; ptrR--;
        }
        return true;
    }
}
