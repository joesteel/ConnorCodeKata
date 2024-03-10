package com.connor.leeteasy;

public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i<32; i++){
            result <<=1;
            int isolated_bit = n & 1;
            result = result | isolated_bit;
            n >>= 1;
        }
        return result;
    }
}
