package com.connor.leeteasy;

public class Compliment {
    public static int findComplement(int num) {
        double highest_bit = Math.log(num)/Math.log(2);
        int mask = 1;
        for(int i = 0; i <= highest_bit; i++){
            num ^= mask;
            mask <<= 1;
        }
        return num;
    }
}
