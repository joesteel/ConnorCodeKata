package com.connor.leeteasy;

public class HappyNumbers {
    public static boolean isHappy(int n) {
        if(n == 1 || n == 7) return true;
        else if(n < 10) return false;
        int result = 0;
        while(n > 0){
            result = result + ((n%10) * (n%10));
            n = n/10;
        }
        return isHappy(result);
    }
}
