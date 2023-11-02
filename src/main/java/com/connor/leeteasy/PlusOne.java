package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // buffer overflow
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, result.length - 1);
        return result;
    }
}
