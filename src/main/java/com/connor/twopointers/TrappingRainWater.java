package com.connor.twopointers;

import java.util.List;

public class TrappingRainWater {

    public static int trappingRainWater(List<Integer> elevations) {
        int result = 0, leftPtr = 0, rightPtr = 1;
        boolean trapWindowOpen = false;
        while(rightPtr < elevations.size()){
            int leftVal = elevations.get(leftPtr).intValue();
            int rightVal = elevations.get(rightPtr).intValue();

            if(leftVal > rightVal && !trapWindowOpen) trapWindowOpen = true;
            if(trapWindowOpen && (leftVal <= rightVal || rightPtr == elevations.size()-1)){
                trapWindowOpen = false;
                result += sumTheTrapWindow(leftPtr, rightPtr, elevations);
            }
            if(trapWindowOpen && rightPtr >= elevations.size()-1) {
                // we have a peak reset the window
                rightPtr = leftPtr+1;
                trapWindowOpen = false;
            }
            if(!trapWindowOpen) leftPtr = rightPtr;
            rightPtr++;
        }
        return result;
    }

    public static int sumTheTrapWindow(int trapStart, int trapEnd, List<Integer> elevations){
        int result = 0;
        int waterline = Math.min(elevations.get(trapStart), elevations.get(trapEnd));
        for(int i = trapStart+1; i < trapEnd; i++) result += waterline - elevations.get(i);
        return result;
    }
}
