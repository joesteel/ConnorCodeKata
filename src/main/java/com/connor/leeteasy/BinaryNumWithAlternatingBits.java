package com.connor.leeteasy;

public class BinaryNumWithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        int previous_bit = n & 1;
        n >>= 1;
        while (n > 0) {
            int current_bit = n & 1;
            if (current_bit == previous_bit) return false;
            previous_bit = current_bit;
            n >>= 1;
        }
        return true;
    }
}
