package com.connor.twopointers;

import java.util.Collections;
import java.util.List;

public class MoveZeros {
    public static void moveZeros(List<Integer> nums) {
        int slow = 0, fast = 0;
        while(fast < nums.size()){
            if(nums.get(slow) == 0 && nums.get(fast) != nums.get(slow)){
                Collections.swap(nums, fast, slow);
                slow++;
            }
            if(nums.get(slow) != 0) slow++;
            fast++;
        }
    }
}
