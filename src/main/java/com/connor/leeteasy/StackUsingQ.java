package com.connor.leeteasy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackUsingQ {
        private final Queue<Integer> q1;
        private final Queue<Integer> q2;
        boolean q1Active;

        public StackUsingQ() {
            q1 = new LinkedList<Integer>();
            q2 = new  LinkedList<Integer>();
            q1Active = true;
        }

        public void push(int x) {
            activeQ().offer(x);
        }

        public int pop() {
            while(activeQ().size() > 1){
                secondaryQ().add(activeQ().poll());
            }
            int result = activeQ().poll();
            switchActiveQ();
            return result;
        }

        public int top() {
            int result = this.pop();
            activeQ().offer(result);
            return result;
        }

        public boolean empty() {
            return activeQ().isEmpty();
        }

        private Queue<Integer> activeQ(){
            return q1Active ? q1 : q2;
        }

        private Queue<Integer> secondaryQ(){
            return !q1Active ? q1 : q2;
        }

        private void switchActiveQ(){
            q1Active = !q1Active;
        }
}
