package com.connor.leeteasy;

public class RangeAdditionII {

    public static int maxCount(int m, int n, int[][] ops) {
        int min_x_op = m,  min_y_op = n;

        for(int[] op_pair : ops){
            min_x_op = Math.min(op_pair[0], min_x_op);
            min_y_op = Math.min(op_pair[1], min_y_op);
        }
        return  min_x_op*min_y_op;
    }
}
