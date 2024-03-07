package com.connor.leeteasy;

public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for(int i = 31; i>=0; i--){
            int bitmask = 1 << i;
            int isolatedBit = bitmask & n;
            if(i>=16) isolatedBit = isolatedBit >>> (i+i-31);
            else if(i<15) isolatedBit = isolatedBit << (31-i-i);
            else isolatedBit = isolatedBit << 1;
            result = isolatedBit | result;
        }
        return result;
    }
}
