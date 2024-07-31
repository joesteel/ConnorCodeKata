package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public int[] hourLookUp;
    int[] minuteLookUp;

    public BinaryWatch(){
        hourLookUp = new int[]  {0,1,2,4,8,0,0,0,0,0,0,Integer.MAX_VALUE};
        minuteLookUp = new int[]{0,0,0,0,0,1,2,4,8,16,32,0, Integer.MAX_VALUE};
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        dfs(turnedOn, 0, 0, 0,0, result);
        return result;
    }

    private void dfs(int bitsTurnedOn, int layer, int bitsUsed, int sumHours, int sumMinutes, List<String> results){
        if(sumHours > 11 || sumMinutes > 59 || layer > 10) return;
        if(bitsUsed == bitsTurnedOn){
            String minutes = sumMinutes > 9 ? Integer.toString(sumMinutes) : "0" + Integer.toString(sumMinutes);
            results.add(Integer.toString(sumHours) + ":" + minutes);
            return;
        }
        dfs(bitsTurnedOn, layer+1, bitsUsed+1, sumHours+this.hourLookUp[layer+1], sumMinutes+this.minuteLookUp[layer+1], results);
        dfs(bitsTurnedOn, layer+1, bitsUsed, sumHours, sumMinutes, results);
    }
}

