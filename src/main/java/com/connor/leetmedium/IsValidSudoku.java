package com.connor.leetmedium;

public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rowFrequencyMaps = new boolean[9][9];
        boolean[][] colFrequencyMaps = new boolean[9][9];
        boolean[][] blockFrequencyMaps = new boolean[9][9];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    int val = (board[i][j]) - '1';
                    int block_index = (i/3 * 3) + j/3;
                    if(rowFrequencyMaps[i][val] || colFrequencyMaps[j][val] || blockFrequencyMaps[block_index][val]) return false;

                    rowFrequencyMaps[i][val] = true;
                    colFrequencyMaps[j][val] = true;
                    blockFrequencyMaps[block_index][val] = true;
                    }
                }
            }
        return true;
    }
}
