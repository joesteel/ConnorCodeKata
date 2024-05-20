package com.connor.leeteasy;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int i: nums){
            if(map.contains(i)) return true;
            map.add(i);
        }
        return false;
    }
}
