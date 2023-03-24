package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class CoinChangeI {

    private static int INF = Integer.MAX_VALUE;

    public static int coinChange(List<Integer> coins, int amount) {
        return coinChange(coins, amount, 0);
    }

    public static int coinChange(List<Integer> coins, int amount, int type) {
        if(type == 0){
            return coinChangeTD(coins, amount);
        } else {
            return coinChangeBO(coins, amount);
        }
    }
    public static int coinChangeTD(List<Integer> coins, int targetAmount){
        if(targetAmount <= 0) return 0;
        int[] memo = new int[targetAmount];
        Arrays.fill(memo, -1);
        int result = dfs(coins, targetAmount, memo, 0, 0);
        return result == Integer.MAX_VALUE ? -1: result;
    }

    public static int dfs(List<Integer> coins, int targetAmount, int[] memo, int level, int runningTotal){
        if(runningTotal > targetAmount) return Integer.MAX_VALUE;
        if(runningTotal == targetAmount) return 0;

        if(memo[runningTotal] != -1 && memo[runningTotal] != Integer.MAX_VALUE){
            return memo[runningTotal]+1 ;
        } else if ( memo[runningTotal] == Integer.MAX_VALUE) return memo[runningTotal];

        int numCoins = Integer.MAX_VALUE;
        for(int coin:coins){
            numCoins = Math.min(numCoins, dfs(coins, targetAmount, memo, level+1, runningTotal+coin));
        }

        int result =  numCoins == Integer.MAX_VALUE ? Integer.MAX_VALUE : numCoins+1;
        memo[runningTotal] = numCoins;
        return result;
    }

    public static int coinChangeBO(List<Integer> coins, int targetAmount){
        long[] dp = new long[targetAmount+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            for(int coin: coins){
                int remainder = i - coin;
                if(remainder >= 0) {
                    dp[i] = Math.min(dp[remainder]+1, dp[i]);
                }
            }
        }
        return dp[targetAmount] == INF ? -1 : (int)dp[targetAmount] ;
    }


}
