package com.connor.dynamicprogramming;

import java.nio.charset.MalformedInputException;
import java.util.Arrays;
import java.util.List;

public class MinimalPathSum {
    public static final int TD = 0;
    public static final int BO = 1;


    public static int minPathSum(List<List<Integer>> grid) {

        return minPathSum(grid, TD);
    }

    public static int minPathSum(List<List<Integer>> grid, int type) {
        switch(type) {
            case TD: return minPathSumTD(grid);
            case BO: return minPathSumBO(grid);
            default: throw new IllegalArgumentException("wrong option mofo");
        }
    }

    public static int minPathSumTD(List<List<Integer>> grid){
        int[][] state = new int[grid.size()][grid.get(0).size()];
        for(int i = 0; i < grid.size(); i++){
            Arrays.fill(state[i], -1);
        }
        return dfs(grid, 0,0, state);
    }

    public static int dfs(List<List<Integer>> grid, int row, int col, int[][] state){
        if(row == grid.size()-1 && col == grid.get(row).size()-1) return grid.get(row).get(col);
        if(row >= grid.size()) return Integer.MAX_VALUE;
        if(col >= grid.get(row).size()) return Integer.MAX_VALUE;

        if(state[row][col] != -1) return state[row][col];
        int result = grid.get(row).get(col) + Math.min(dfs(grid, row+1, col, state), dfs(grid, row, col+1, state));
        state[row][col] = result;
        return result;
    }

    public static int minPathSumBO(List<List<Integer>> grid){
        return 0;
    }

}
