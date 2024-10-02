package com.connor.leeteasy;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    result += 4-countNeighbours(i,j,grid);
                }
            }
        }
        return result;
    }

    private static int countNeighbours(int row, int col, int[][] grid){
        int result = 0;
        int grid_height = grid.length;
        int grid_width = grid[0].length;
        if(col >= 1) { // left
            if(grid[row][col-1] != 0) result += 1;
        }
        if(col < grid_width-1) { // right
            if(grid[row][col +1] != 0) result += 1;
        }
        if(row > 0) { // up
            if(grid[row-1][col] != 0) result += 1;
        }
        if(row < grid_height-1) { // down
            if(grid[row+1][col] != 0) result += 1;
        }
        return result;
    }
}
