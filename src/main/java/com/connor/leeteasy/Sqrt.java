package com.connor.leeteasy;

public class Sqrt {

    public static int mySqrt(int x) {
        return bs(1, x, x);
    }

    private static int bs(int start, int end, int target){
        if(start > end) return end;
        int current = (end - start)/2 + start;

        long current_square = (long)current*current;
        if(current_square == target) return current;
        else if (current_square > target) {
            return bs(start, current-1, target);
        } else {
            return bs(current+1, end, target);
        }
    }
}
