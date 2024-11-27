package com.connor.leeteasy;

public class Fib {
    public static int fib(int n) {
        int[] state = new int[n+1];
        return fibWithMemo(n, state);
    }

    private static int fibWithMemo(int n, int[] state){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int result = 0;
        result += state[n-1] != 0 ? state[n-1] : fibWithMemo(n-1, state);
        result += state[n-2] != 0 ? state[n-2] : fibWithMemo(n-2, state);
        state[n] = result;

        return result;
    }
}
