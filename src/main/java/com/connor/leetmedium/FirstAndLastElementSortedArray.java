package com.connor.leetmedium;

public class FirstAndLastElementSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] == target) {
                return numberBoundary(nums, mid);
            } else if(nums[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }

    private static int[] numberBoundary(int[] nums, int k) {
        int l = k, r = k;
        while(l > 0) {
            if(nums[l-1] == nums[k]) l--;
            else break;
        }
        while(r < nums.length-1) {
            if(nums[r+1] == nums[k]) r++;
            else break;
        }
        return new int[] {l, r};
    }
}
