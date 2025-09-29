package com.connor.leeteasy;

import java.util.Stack;

public class BaseBallGame {

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s: operations ) {
            switch (s) {
                case "+" :
                    int x = stack.pop();
                    int y = stack.peek();
                    stack.push(x);
                    stack.push(x+y);
                    break;
                case "D" :
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.stream().mapToInt(x->x).sum();
    }
}
