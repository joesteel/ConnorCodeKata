package com.connor.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static final int BO = 1;

    public static int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle,0);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int type) {
        int result = 0;
        if(type == 0){
            List<List<Integer>> memo =  createMemo(triangle);
            result = minTotalTD(triangle, memo, 0,0);
        } else {
            result = minTotalBO(triangle);
        }
        return result;
    }

    public static int minTotalTD(List<List<Integer>> triangle, List<List<Integer>> memo, int currentLevel, int node ){
        if(currentLevel == triangle.size()-1) return triangle.get(currentLevel).get(node);

        if(memo.get(currentLevel).get(node) != -1) return  memo.get(currentLevel).get(node);
        int leftSubtreeResult = minTotalTD(triangle, memo, currentLevel+1, node);
        int rightSubtreeResult = minTotalTD(triangle, memo, currentLevel+1, node+1);
        int result = Math.min(leftSubtreeResult, rightSubtreeResult) + triangle.get(currentLevel).get(node);

        return result;
    }


   public static List<List<Integer>> createMemo(List<List<Integer>> triangle){
       List<List<Integer>> memo = new ArrayList<>(triangle.size());
       for(List<Integer> level: triangle){
           List<Integer> memoLevel = new ArrayList<>();
           for(int node: level) memoLevel.add(-1);
           memo.add(memoLevel);
       }
       return memo;
   }


   public static int minTotalBO(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[n-1][i] = triangle.get(n-1).get(i);

        for(int i = n-2; i>=0; i-- ){
            for(int j=0; j<triangle.get(i).size(); j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
   }

}
