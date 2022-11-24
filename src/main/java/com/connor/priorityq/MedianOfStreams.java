package com.connor.priorityq;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreams {
    public static class MedianOfStream {
        private PriorityQueue<Double> smallHeap;
        private PriorityQueue<Double> largeHeap;

        public MedianOfStream(){
            smallHeap = new PriorityQueue<>(Collections.reverseOrder());
            largeHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(smallHeap.size() == 0 || num < smallHeap.peek()){
                smallHeap.add((double)num);
            } else {
                largeHeap.add((double)num);
            }
            _balance();
        }

        public double getMedian() {
            double result = 0;
            if(smallHeap.size() == largeHeap.size()){
                result = (smallHeap.peek() + largeHeap.peek())/2;
            } else {
                result = smallHeap.peek();
            }
            return result;
        }

        private void _balance(){
            if(smallHeap.size() > largeHeap.size()+1){
                largeHeap.add(smallHeap.poll());
            }
            if(largeHeap.size() > smallHeap.size()){
                smallHeap.add(largeHeap.poll());
            }
        }
    }
}
