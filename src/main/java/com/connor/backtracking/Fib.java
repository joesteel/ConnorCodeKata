package com.connor.backtracking;

public class Fib {

    public static int fib(int n, Integer[] memo){
        if(n == 0 || n == 1) {
            return n;
        }
        if(memo[n] != null) return memo[n];
        else{
            int result = fib(n-1, memo) + fib(n-2, memo);
            // memo[n] = new Integer(result); todo - java version issues
            return result;
        }
    }
}
