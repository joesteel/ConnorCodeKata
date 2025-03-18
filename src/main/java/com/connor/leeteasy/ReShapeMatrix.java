package com.connor.leeteasy;

public class ReShapeMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != (mat.length * mat[0].length) || r <= 0 || (r == mat.length && c == mat[0].length))  return mat;
        int[][] result = new int[r][c];
        int write_row = 0, write_col = 0;

        for (int[] read_row : mat) {
            for (int read_col = 0; read_col < read_row.length; read_col++) {
                if (write_col == c) {
                    //another way to do this is to say if write_col % c == 0 and initialize the row to -1
                    write_row++;
                    write_col = 0;
                }
                result[write_row][write_col] = read_row[read_col];
                write_col++;
            }
        }
        return result;
    }
}
