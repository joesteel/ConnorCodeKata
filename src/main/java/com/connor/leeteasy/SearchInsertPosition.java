package com.connor.leeteasy;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int partition_start, int partition_end){
        if(partition_start > partition_end) return partition_start;

        int half_way_point = partition_start + (partition_end - partition_start)/2;
        if(target == nums[half_way_point]) return half_way_point;

        else if(target < nums[half_way_point]) return binarySearch(nums, target, partition_start, half_way_point-1);
        else return binarySearch(nums, target, half_way_point+1, partition_end);
    }
}
