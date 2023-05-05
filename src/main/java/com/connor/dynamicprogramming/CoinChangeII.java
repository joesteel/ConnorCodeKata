package com.connor.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class CoinChangeII {
    public static int coinGame(List<Integer> coins, int amount) {
        return coinGame(coins, amount, "top down");
    }

    public static int coinGame(List<Integer> coins, int amount, String type) {
        if(type.toLowerCase().equals("top down")) return coinGameTD(coins, amount);
        else return 0;
    }

    public static int coinGameTD(List<Integer> coins, int amount){
        int[][] dp = new int[coins.size()][amount + 1];
        for (int i = 0; i < coins.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = dfs(coins, amount, 0, dp, 0, 0);
        return result;
    }

    public static int dfs(List<Integer> coins, int target, int level, int[][] dp, int currentSum, int start){
        if(currentSum == target) return 1;
        if(currentSum >= target) return 0;

        if(dp[start][currentSum] != -1){
            return dp[start][currentSum];
        }

        int result = 0;
        for(int i = start; i < coins.size(); i ++){
            result += dfs(coins, target, level+1, dp, currentSum+coins.get(i), i);
        }

        dp[start][currentSum] = result;
        return result;
    }
}
