package com.connor.leeteasy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        int advised_total = candyType.length/2;
        Set<Integer> set = new HashSet<>();
        for(int candy: candyType){
            set.add(candy);
        }
        int unique_candies = set.size();
        return Math.min(advised_total, unique_candies);
    }
}
