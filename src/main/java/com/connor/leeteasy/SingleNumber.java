package com.connor.leeteasy;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) {
                set.remove(num);
            } else set.add(num);
        }
        Iterator<Integer> itr = set.iterator();
        return itr.next();
    }
}
