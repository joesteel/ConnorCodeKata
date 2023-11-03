package com.connor.dynamicprogramming;

public class DivisorGame {
    public static boolean divisorGame(int n) {
        boolean[] state = new boolean[n+1];
        state[0] = false; state[1] = false;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i/2; j++) {
                if(i%j == 0) {
                    state[i] = !state[i-j];
                    if(state[i]) break;
                }
            }

        }
        return state[n];
    }



}
