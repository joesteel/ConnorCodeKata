package com.connor.leetmedium;

public class StringToIntAtoi {

    enum States {
        ProcessingWhiteSpace,
        ProcessingSign,
        ProcessingNum
    };
    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        long result = 0;
        int sign = 1;
        States state = States.ProcessingWhiteSpace;
        for(char c: chars){
            if(state == States.ProcessingWhiteSpace){
                if(c == ' ') continue;
                else state = States.ProcessingSign;
            }
            if(state == States.ProcessingSign){
                if(c == '-' || c == '+') {
                    if(c== '-') sign = -1;
                    state = States.ProcessingNum;
                    continue;
                }
                state = States.ProcessingNum;
            }
            if(state == States.ProcessingNum){
                if(c >= '0' && c <= '9' && result < Integer.MAX_VALUE && result > Integer.MIN_VALUE){
                    result*=10;
                    result += c - 48;
                } else {
                    break;
                }
            }
        }
        result *= sign;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)result;
    }
}
