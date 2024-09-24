package com.connor.leeteasy;

public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        long c = (long)n*2;
        double result =  (Math.sqrt(1 + 4*c)/2 - .5);
        return (int)Math.floor(result);
    }
}
