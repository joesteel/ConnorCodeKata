package com.connor.twopointers;

import java.util.List;

public class TrappingRainWater {

    public static int trappingRainWater(List<Integer> elevations) {
        int result = 0, leftPtr = 0, rightPtr = 1;
        boolean trapWindowOpen = false;
        while(rightPtr < elevations.size()){
            int leftVal = elevations.get(leftPtr).intValue();
            int rightVal = elevations.get(rightPtr).intValue();

            int[] highestElevationToTheRight = findHighestEvelationsToTheRight(elevations);
            if(leftVal > rightVal && !trapWindowOpen) trapWindowOpen = true;
            if(trapWindowOpen && (leftVal <= rightVal || rightVal == highestElevationToTheRight[rightPtr])){
                trapWindowOpen = false;
                result += sumTheTrapWindow(leftPtr, rightPtr, elevations);
            }
            if(!trapWindowOpen) leftPtr = rightPtr;
            rightPtr++;
        }
        return result;
    }

    public static int[] findHighestEvelationsToTheRight(List<Integer> elevations){
        int[] highestElevationToTheRight = new int[elevations.size()];
        int max = 0;
        for(int i = elevations.size()-1; i>=0; i--){
            max = Math.max(max, elevations.get(i));
            highestElevationToTheRight[i] = max;
        }
        return highestElevationToTheRight;
    }

    public static int sumTheTrapWindow(int trapStart, int trapEnd, List<Integer> elevations){
        int result = 0;
        int waterline = Math.min(elevations.get(trapStart), elevations.get(trapEnd));
        for(int i = trapStart+1; i < trapEnd; i++) result += waterline - elevations.get(i);
        return result;
    }
}
