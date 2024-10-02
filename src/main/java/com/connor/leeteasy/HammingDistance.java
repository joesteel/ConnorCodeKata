package com.connor.leeteasy;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        int mask = 0x1;
        for(int i = 0; i < 32; i++){
            if((xor & mask) == 1) distance++;
            xor >>= 1;
        }
        return distance;
    }
}
