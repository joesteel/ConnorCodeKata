package com.connor.leeteasy;

public class ConstructRectangle {
    public static int[] constructRectangle(int area) {
        int[] dimensions = new int[]{0,0};
        int w = (int)Math.sqrt(area), l = 0;
        while(w >= 1){
            if(area % w == 0) {
                l = area/w;
                break;
            }
            w--;
        }
        dimensions[0] = l;
        dimensions[1] = w;
        return dimensions;
    }
}
