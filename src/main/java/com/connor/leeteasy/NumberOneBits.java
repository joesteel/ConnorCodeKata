package com.connor.leeteasy;

public class NumberOneBits {

    public static int hammingWeight(int n) {
        int result = 0;
        int bitmask = 0x0000001;
        for(int i = 0; i < 32; i++){
            int isolatedBit = n & bitmask;
            result = result + isolatedBit;
            n >>= 1;
        }
        return result;
    }
}
