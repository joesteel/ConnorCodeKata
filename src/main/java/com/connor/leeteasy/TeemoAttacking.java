package com.connor.leeteasy;

public class TeemoAttacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        // Two options I can think of
        // a. iterate through the list and decide how much score to add for Xi when we get to Xi+1, weird end loop conditions
        // b. iterate through the list and add the score at Xi but correct the score when we get to Xi+1...
        // b is a bit cleaner
        int result = duration;
        for(int i = 1; i < timeSeries.length; i++){
            result += duration;
            int delta = timeSeries[i] - timeSeries[i-1];
            if(delta < duration){
                int overlap =  duration - delta;
                result = result - overlap;
            }
        }
        return result;
    }
}
