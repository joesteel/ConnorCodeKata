package com.connor.dynamicprogramming;

public class PerfectSquare {
    public static int perfectSquares(int n) {
        int[] state = new int[n+1];
        state[0] = Integer.MAX_VALUE; state[1] = 1;
        for(int i = 2; i < state.length; i++){
            if(Math.sqrt(i)%1 == 0) state[i] = 1;
            else {
                int least_squares = Integer.MAX_VALUE;
                for(int j = i-1; j >= 0; j--) {
                    if(state[j] < least_squares) {
                        int result = state[j] + state[i-j];
                        least_squares = Math.min(least_squares, result);
                    }
                }
                state[i] = least_squares;
            }
        }
        return state[n];
    }
}
