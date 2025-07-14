package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSum {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index = new HashMap<>();
        List<String> result = new ArrayList<>();
        int min_index = Integer.MAX_VALUE;

        String[] smallest_list = list1.length <= list2.length ? list1 : list2;
        String[] largest_list = list1.length > list2.length ? list1 : list2;

        for(int i = 0; i< smallest_list.length;i++){
            index.put(smallest_list[i],i);
        }
        for(int i = 0; i< largest_list.length; i++){
            Integer index_val = index.get(largest_list[i]);
            if(index_val != null){
                int summed_index = i+index_val;
                if(summed_index < min_index){
                    result.clear();
                    result.add(largest_list[i]);
                    min_index = summed_index;
                } else if(summed_index == min_index) {
                    result.add(largest_list[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
