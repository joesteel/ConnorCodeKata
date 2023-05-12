package com.connor.dynamicprogramming;

import java.util.Arrays;

public class RobotPaths {

    public static int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(m, n, 1, 1, memo);
    }

    public static int dfs(int cols, int rows, int colPos, int rowPos, int[][] memo){
        if(colPos > cols || rowPos > rows) return 0;
        if(colPos == cols && rowPos == rows) return 1;

        if(memo[colPos][rowPos] > -1) return memo[colPos][rowPos];

        int result = 0;
        result = dfs(cols, rows, colPos+1, rowPos, memo) + dfs(cols, rows, colPos, rowPos+1, memo);
        memo[colPos][rowPos] = result;

        return result;
    }

}
