package com.connor.leeteasy;

import java.util.Stack;

public class QUsingStack {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public QUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while(s1.size() > 1) s2.push(s1.pop());
        int result = s1.pop();
        while (!s2.empty()) s1.push(s2.pop()); // may not need this
        return result;

    }

    public int peek() {
        while(s1.size() > 1) s2.push(s1.pop());
        int result = s1.peek();
        while (!s2.empty()) s1.push(s2.pop()); // may not need this
        return result;
    }

    public boolean empty() {
        return s1.empty();
    }
}
