package com.connor.leeteasy;

import java.util.Arrays;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] state = new int[n];
        Arrays.fill(state, -1);
        state[0] = 1;
        return computeVal(n, state);
    }

    private static int computeVal(int n, int[] state){
        if(n == 1 || n == 0) return 1;

        int result;
        if(state[n-1] != -1) return state[n-1];
        else {
            result = computeVal(n - 1, state) + computeVal(n - 2, state);
        }
        state[n-1] = result;
        return result;
    }
}
