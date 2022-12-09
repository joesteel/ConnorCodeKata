package com.connor.twopointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

    public static int removeDuplicates(List<Integer> arr) {
        int p1 = 0, p2 = 0;
        while(p2 < arr.size()){
            if(arr.get(p1) != arr.get(p2)) {
                p1++;
                arr.set(p1, arr.get(p2));
            }
            p2++;
        }
        p1++;
        while(p1 < arr.size()){
            arr.remove(p1);
        }
        return arr.size();
    }

}
