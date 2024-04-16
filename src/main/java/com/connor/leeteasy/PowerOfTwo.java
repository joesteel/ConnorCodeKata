package com.connor.leeteasy;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        int mask = 0x1;
        for(int i = 0; i < 31; i++){
            if((mask | n) == mask) return true;
            mask <<= 1;
        }
        return false;
        
        // smarter way I saw on l33t return n > 0 && (n & (n-1) == 0)
    }
}
