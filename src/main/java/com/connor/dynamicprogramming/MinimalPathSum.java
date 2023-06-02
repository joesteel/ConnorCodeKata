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
        int rows = grid.size(), cols = grid.get(0).size();
        int[][] state = new int[rows][cols];

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                if(i == 0 && j == 0) {
                    state[i][j] = grid.get(i).get(j);
                } else if (i == 0) {
                    state[i][j] = grid.get(i).get(j) + state[i][j-1];
                } else if (j == 0) {
                    state[i][j] = grid.get(i).get(j) + state[i-1][j];
                } else {
                    state[i][j] = grid.get(i).get(j) + Math.min(state[i][j-1], state[i-1][j]);
                }
            }
        }

        return state[rows-1][cols-1];
    }

}
