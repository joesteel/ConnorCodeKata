package com.connor.leeteasy;

public class CanGrowFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int available_spots = 0;

        int i = 0;
        while(i < flowerbed.length){
            int previous = (i > 0) ? flowerbed[i-1] : 0;
            int next = (i < flowerbed.length-1) ? flowerbed[i+1]: 0;
            int current = flowerbed[i];

            if(previous == 0 && current == 0 && next == 0){
                available_spots++;
                if(available_spots >= n) return true;
                i+=2;
            } else i++;
        }
        return false;
    }
}
