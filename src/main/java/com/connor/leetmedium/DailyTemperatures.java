package com.connor.leetmedium;

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monotonicStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!monotonicStack.isEmpty() && temperatures[monotonicStack.peek()] < temperatures[i]){
                int lowerTempIndex = monotonicStack.pop();
                result[lowerTempIndex] = i - lowerTempIndex;
            }
            if(monotonicStack.isEmpty() || temperatures[monotonicStack.peek()] >= temperatures[i]){
                monotonicStack.push(i);
            }
        }
        while(!monotonicStack.isEmpty()){
            result[monotonicStack.pop()] = 0;
        }
        return result;
    }

}
