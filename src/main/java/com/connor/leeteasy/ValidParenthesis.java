package com.connor.leeteasy;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            switch(c) {
                case '}' :
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']' :
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                default:stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
