package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;
        int count = num-1;
        int divisor = 1;
        int quotient = num;
        while(++divisor < quotient){
            quotient = num/divisor;
            if(num % divisor == 0)
                count = count - divisor - quotient;
        }
        return count == 0;
    }
}
