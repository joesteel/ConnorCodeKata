package com.connor.leeteasy;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        while(start <= end){
            int mid = start + (end - start)/2;
            long guess = (long)mid*mid;
            if(guess == num) return num % mid == 0;
            if(guess > num){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
