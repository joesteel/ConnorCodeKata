package com.connor.leetmedium;

public class SearchInRotatedSortedArray {

    // another easy way to do this is to find the pivot and binary search in 2 parts

    public static int search(int[] nums, int target) {
        int rotation_point=0;
        for(int i = 1; i<nums.length;i++)
            if(nums[i]<nums[i-1]) rotation_point = i;

        int start = 0, end = nums.length-1;
        while(start <= end){
            int middle = start + ((end - start)/2);
            int un_rotated_index = unRotateIndex(middle, rotation_point, nums.length);
            if(nums[un_rotated_index] == target) return un_rotated_index;
            else if(target > nums[un_rotated_index]) start = middle+1;
            else end = middle-1;
        }

        return -1;
    }

    private static int unRotateIndex(int x, int rotation_point, int size){
        int index = x+rotation_point+size;
        return index%size;
    }

}
