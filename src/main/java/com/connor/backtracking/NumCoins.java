package com.connor.backtracking;

import java.util.Collections;
import java.util.List;

public class NumCoins {

    public static int coinChange(List<Integer> coins, int amount) {
        // WRITE YOUR BRILLIANT CODE HERE
        int result = dfs(0, coins, amount, new Integer[amount+1]);
        if(result == Integer.MAX_VALUE) result = -1;
        return result;
    }

    public static int dfs(int height, List<Integer> coins, int amount, Integer[] memo){
        if(amount == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE-1;
        if(memo[amount] != null) return memo[amount];

        for(int coin: coins){
            int remainder = amount - coin;
            if(remainder >= 0){
                result = Math.min(result, dfs(height+1, coins, remainder, memo));
                break;
            }
        }
        memo[amount] = result+1;
        return result+1;
    }


    public static void reverseMergeSort(List<Integer> listToSort){

    }


}
